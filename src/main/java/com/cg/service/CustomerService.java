 package com.cg.service;

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
  
  public List<Customer> getAllCustomers(){
	  return customerRepository.findAll();
  }
  
  public List<Hall> findHallByCity(String city) {
	  return hallRepository.findByCity(city);
  }
  
  public Hall findHallByLocation(String city,String location) {
	  return hallRepository.findByCityAndLocation(city , location);
  }
  
  public String BookHall(String city,String location){
	  Hall hall = hallRepository.findByCityAndLocation(city , location);
	  if(hall == null) return "Currently no halls available at your location";
	  else {
		  hall.setBookingStatus(true);
		  return "Hall booked Successfully";
	  }
  }
  
}