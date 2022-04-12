 package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Customer;
import com.cg.repository.CustomerRepository;

@Service
public class CustomerService {
  @Autowired
  private CustomerRepository rrepo;
  
  public String addCustomer(Customer c) {
	  rrepo.save(c);
	  return "Customer added successfully";
  }
  
  
  public List<Customer> getAllCustomers(){
	  return rrepo.findAll();
  }
}