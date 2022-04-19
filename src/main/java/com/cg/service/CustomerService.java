package com.cg.service;

import java.util.Date;
import java.util.List;

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

	public ResponseEntity<Object> addCustomer(Customer c) {
		customerRepository.save(c);
		return new ResponseEntity<Object>("Customer Added successfully", HttpStatus.OK);
	}

	public ResponseEntity<Object> getAllCustomers() {
		List<Customer> customers = customerRepository.findAll();
		return new ResponseEntity<Object>(customers, HttpStatus.OK);

	}

	public ResponseEntity<Object> removeCustomer(int id) {
		customerRepository.deleteById(id);
		return new ResponseEntity<Object>("Customer deleted successfully", HttpStatus.OK);
	}

	public ResponseEntity<Object> BookHall(int customerId, String city, String location, boolean flower,
			boolean catering,
			boolean music, boolean video) {
		Customer c = customerRepository.findById(customerId).get();
		List<Hall> halls = hallRepository.findByHallCityAndHallLocation(city, location);
		if (halls == null)
			return new ResponseEntity<Object>("Currently no halls available at your location", HttpStatus.OK);
		else {
			for (Hall h : halls) {

				if (h.getHallBookedFrom() == null && h.getHallBookedTo() == null) {
					h.setHallBookedFrom(c.getBookHallFrom());
					h.setHallBookedTo(c.getBookHallTo());
				} else if (c.getBookHallFrom().after(h.getHallBookedTo())
						|| c.getBookHallTo().before(h.getHallBookedFrom())) {

					h.setHallBookedFrom(c.getBookHallFrom());
					h.setHallBookedTo(c.getBookHallTo());

				} else {

					return new ResponseEntity<Object>(
							"Hall already booked for your mentioned duration, please select another slot.",
							HttpStatus.OK);

				}
				boolean status = vendorService.bookVendor(h.getHallId(), c.getBookHallFrom(),
						c.getBookHallTo(), flower, catering, music, video);

				if (!status) {

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

				return new ResponseEntity<Object>(
						"Hall and vendor boooked successfully, your bill amount is: " + bill, HttpStatus.OK);

			}
			return new ResponseEntity<Object>("Hall already booked at that duration", HttpStatus.OK);
		}
	}

}