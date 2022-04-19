package com.cg.service;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.entity.Customer;
import com.cg.entity.Hall;
import com.cg.entity.Supervisor;
import com.cg.repository.CustomerRepository;
import com.cg.repository.HallRepository;
import com.cg.repository.SupervisorRepository;
import com.cg.service.VendorService;
import com.cg.exception.HallNotFoundException;
import com.cg.exception.CustomerNotLoggedInException;
import com.cg.exception.HallNotAvailableException;
import com.cg.exception.InvalidCredentialsException;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private HallRepository hallRepository;

	@Autowired
	private VendorService vendorService;

	@Autowired
	private SupervisorService supervisorService;

	@Autowired
	private HallService hallService;

	static Logger log = Logger.getLogger(CustomerService.class.getName());

	Customer currentCustomer = null;

	public ResponseEntity<Object> loginCustomer(String email, String password) {

		if ((currentCustomer = customerRepository.findByCustomerEmailAndCustomerPassword(email, password)) != null) {
			log.info("Customer loggedin");
			return new ResponseEntity<Object>("Customer login successfull.", HttpStatus.OK);
		}

		log.error("No customer is currently logged-In");
		throw new InvalidCredentialsException("Customer login failed, invalid credentials.");
	}

	public ResponseEntity<Object> logoutCustomer() {

		if (currentCustomer != null) {
			currentCustomer = null;
			log.info("customer loggedout");
			return new ResponseEntity<Object>("Customer logout successfull.", HttpStatus.OK);
		}
		log.error("No customer is currently logged-In");
		throw new CustomerNotLoggedInException("Error, currently no Customer logged-in.");
	}

	public ResponseEntity<Object> addCustomer(Customer c) {
		customerRepository.save(c);
		log.info("Customer added");
		return new ResponseEntity<Object>("Customer Added successfully", HttpStatus.OK);
	}

	public ResponseEntity<Object> BookHall(int customerId, String city, String location, boolean flower,
			boolean catering,
			boolean music, boolean video) {
		if (currentCustomer != null) {
			Customer c = customerRepository.findById(customerId).get();
			List<Hall> halls = hallRepository.findByHallCityAndHallLocation(city, location);
			if (halls == null) {
				log.error("No hall available in " + city + " at " + location);
				throw new HallNotFoundException("Currently no halls available at your location");
			} else {
				for (Hall h : halls) {

					if (h.getHallBookedFrom() == null && h.getHallBookedTo() == null) {
						h.setHallBookedFrom(c.getBookHallFrom());
						h.setHallBookedTo(c.getBookHallTo());
					} else if (c.getBookHallFrom().after(h.getHallBookedTo())
							|| c.getBookHallTo().before(h.getHallBookedFrom())) {

						h.setHallBookedFrom(c.getBookHallFrom());
						h.setHallBookedTo(c.getBookHallTo());

					} else {
						log.error("Hall already booked for mentioned duration");
						throw new HallNotAvailableException(
								"Hall already booked for your mentioned duration, please select another slot.");
					}
					boolean status = vendorService.BookVendor(h.getHallId(), c.getBookHallFrom(),
							c.getBookHallTo(), flower, catering, music, video);

					if (!status) {
						log.error("No vendor available for mentioned service");
						return new ResponseEntity<Object>(
								"No vendor available for mentioned services, please slect another combinations.",
								HttpStatus.OK);
					}

					List<Hall> hallList = c.getHalls();
					hallList.add(h);

					c.setHalls(hallList);
					h.setHallBookingStatus(true);

					double bill = supervisorService.generateBill(h.getHallId(), flower, catering, music, video);

					c.setCustomerBill(Math.round(bill));

					hallService.updateRevenue(h.getHallId(), bill);

					hallRepository.save(h);
					customerRepository.save(c);
					log.info("Hall and vendor booked successfully");
					return new ResponseEntity<Object>(
							"Hall and vendor boooked successfully, your bill amount is: " + bill, HttpStatus.OK);

				}
				log.error("Hall already booked at that duration");
				return new ResponseEntity<Object>("Hall already booked at that duration", HttpStatus.OK);
			}
		}
		log.error("No customer logged-in");
		throw new CustomerNotLoggedInException("No customer logged in, please login as customer");
	}

}