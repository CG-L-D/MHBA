package com.cg.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.entity.Customer;
import com.cg.entity.Hall;
import com.cg.repository.CustomerRepository;
import com.cg.repository.HallRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private HallRepository hallRepository;
	
	Customer currentCustomer = null;

	public String addCustomer(Customer c) {
		customerRepository.save(c);
		return "Customer added successfully";
	}

	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	public String removeCustomer(int id) {
		customerRepository.deleteById(id);
		return "Customer deleted successfully";
	}

    public ResponseEntity<Object> loginCustomer(String email, String password){
		
		if((currentCustomer = customerRepository.findByCustomerEmailAndPassword(email, password)) != null){
			return new ResponseEntity<Object>("Customer login successfull.", HttpStatus.OK);
		}
		
		return new ResponseEntity<Object>("Customer login failed, invalid credentials.", HttpStatus.FORBIDDEN);
	}
	
	public ResponseEntity<Object> logoutCustomer(){
		
		if(currentCustomer != null){
			currentCustomer = null;
			return new ResponseEntity<Object>("Customer logout successfull.", HttpStatus.OK);
		}
		
		return new ResponseEntity<Object>("Error, currently no customer logged-in.", HttpStatus.BAD_REQUEST);
	}
	
	public String BookHall(String city, String location, int customerId) {
		if(currentCustomer != null) {
			Customer c = customerRepository.findById(customerId).get();
			List<Hall> halls = hallRepository.findByCityAndLocation(city, location);
			if(halls == null) return "Currently no halls available at your location"; 
			else {
				for(Hall h:halls) {
				  if(!h.getBookingStatus()) {
					    if (h.getBookedFrom() == null && h.getBookedTo() == null) {
							h.setBookedFrom(c.getBookHallFrom());
							h.setBookedTo(c.getBookHallTo());
						}
						else if(c.getBookHallFrom().after(h.getBookedTo()) || c.getBookHallTo().before(h.getBookedFrom())) {
								h.setBookedFrom(c.getBookHallFrom());
								h.setBookedTo(c.getBookHallTo());
						}

						List<Hall> hallList = c.getHall();
						hallList.add(h);

						c.setHall(hallList);
						h.setBookingStatus(true);
						hallRepository.save(h);
						customerRepository.save(c);
						return "Hall booked Successfully";
				  }
				}
				return "Hall already booked at that duration";
			}
		}
		return "Customer not found";
	}
	

}