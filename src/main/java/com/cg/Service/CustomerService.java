package com.cg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Customer;
import com.cg.repository.CustomerRepository;

@Service
public class CustomerService {
  @Autowired
  private CustomerRepository rrepo;
  
  
  
}
