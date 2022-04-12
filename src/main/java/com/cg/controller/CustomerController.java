package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Customer;
import com.cg.service.CustomerService;

@RestController
class CustomerController {
  @Autowired
  private CustomerService cservice;
  
  @PostMapping("/addCustomer")
  public String addCustomer(@RequestBody Customer c) {
	  return cservice.addCustomer(c);
  }
  
  @GetMapping("/getAllCustomers")
  public List<Customer> getAllCustomers() {
	  return cservice.getAllCustomers();
  }
}