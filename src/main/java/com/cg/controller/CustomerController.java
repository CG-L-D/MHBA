package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Customer;
import com.cg.entity.Hall;
import com.cg.service.CustomerService;

@RestController
public class CustomerController {
  @Autowired
  private CustomerService customerService;
  
  @PostMapping("/addCustomer")
  public String addCustomer(@RequestBody Customer c) {
	  return customerService.addCustomer(c);
  }
  
  @GetMapping("/getAllCustomers")
  public List<Customer> getAllCustomers(){
	  return customerService.getAllCustomers();
  }
  
  @DeleteMapping("/removeCustomer/{id}")
  public String removeCustomer(@PathVariable int id) {
	  return customerService.removeCustomer(id);
  }
  
  @GetMapping("/getHallByCity/{city}")
	public List<Hall> getHallByCity(@PathVariable String city) {
		return customerService.findHallByCity(city);
	}
  
  @GetMapping("/getHallByLocation/{city}/{location}")
	public Hall getHallByLocation(@PathVariable String city,@PathVariable String location) {
		return customerService.findHallByLocation(city,location);
	}
  
  @PostMapping("/bookHall/{city}/{location}/{customerId}")
	public String bookHall(@PathVariable String city,@PathVariable String location,@PathVariable int customerId) {
		return customerService.BookHall(city,location,customerId);
  } 
}