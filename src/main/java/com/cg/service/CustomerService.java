package com.cg.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	public String BookHall(String city, String location, int customerId) {
		Customer c = customerRepository.findById(customerId).get();
		List<Hall> halls = hallRepository.findByCityAndLocation(city, location);
		Hall hall = halls.get(0);
		if (hall == null)
			return "Currently no halls available at your location";
		else {
			if (hall.getBookedFrom() == null && hall.getBookedTo() == null) {
				hall.setBookedFrom(c.getBookHallFrom());
				hall.setBookedTo(c.getBookHallTo());
			} else {
				if (c.getBookHallFrom().after(hall.getBookedTo()) || c.getBookHallTo().before(hall.getBookedFrom())) {
					hall.setBookedFrom(c.getBookHallFrom());
					hall.setBookedTo(c.getBookHallTo());
				}
			}

			List<Hall> hallList = c.getHall();
			hallList.add(hall);

			c.setHall(hallList);
			hall.setBookingStatus(true);
			hallRepository.save(hall);
			customerRepository.save(c);
			return "Hall booked Successfully";
		}
	}

}