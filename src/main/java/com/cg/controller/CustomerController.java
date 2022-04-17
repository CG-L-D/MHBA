package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Customer;
import com.cg.entity.Hall;
import com.cg.service.CustomerService;
import com.cg.service.HallService;
import com.cg.service.VendorService;

@RestController
public class CustomerController {
  @Autowired
  private CustomerService customerService;

  @Autowired
  private HallService hallService;

  @Autowired
  private VendorService vendorService;

  @PostMapping("/addCustomer")
  public String addCustomer(@RequestBody Customer c) {
    return customerService.addCustomer(c);
  }

  @GetMapping("/getAllCustomers")
  public List<Customer> getAllCustomers() {
    return customerService.getAllCustomers();
  }

  @DeleteMapping("/removeCustomer/{id}")
  public String removeCustomer(@PathVariable int id) {
    return customerService.removeCustomer(id);
  }

  @GetMapping("/getHallByCity/{city}")
  public ResponseEntity<Object> getHallByCity(@PathVariable String city) {
    return hallService.findHallByCity(city);
  }

  @GetMapping("/getHallByLocation/{city}/{location}")
  public ResponseEntity<Object> getHallByLocation(@PathVariable String city, @PathVariable String location) {
    return hallService.findHallByLocation(city, location);
  }

  @GetMapping("/getHallByCapacity/{city}/{capacity}")
  public ResponseEntity<Object> getHallByCapacity(@PathVariable String city, @PathVariable int capacity) {
    return hallService.findByCapacity(city, capacity);
  }

  @PostMapping("/bookHall/")
  public String bookHall(@RequestBody int customerId, @RequestBody String city, @RequestBody String location,
                          @RequestBody boolean flower, @RequestBody  boolean catering, @RequestBody boolean music, @RequestBody boolean video) {
    return customerService.BookHall(
      city, 
      location, 
      customerId,
      flower,
      catering,
      music,
      video
      );
  }
  

  

  
}