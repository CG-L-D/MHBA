package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.entity.Customer;
import com.cg.service.CustomerService;
import com.cg.service.HallService;

@RestController
public class CustomerController {
  @Autowired
  private CustomerService customerService;

  @Autowired
  private HallService hallService;

  @RequestMapping(value = "/loginCustomer/{email}/{password}")
  public ResponseEntity<Object> loginAdmin(@PathVariable String email, @PathVariable String password) {
    return customerService.loginCustomer(email, password);
  }

  @RequestMapping(value = "/logoutCustomer")
  public ResponseEntity<Object> logoutCustomer() {

    return customerService.logoutCustomer();
  }

  @PostMapping("/addCustomer")
  public ResponseEntity<Object> addCustomer(@RequestBody Customer c) {
    return customerService.addCustomer(c);
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

  @GetMapping("/getAllHall")
  public ResponseEntity<Object> getHall() {
    return hallService.getAllHall();
  }

  @PostMapping("/bookHall/{city}/{location}/{flower}/{catering}/{music}/{video}")
  public ResponseEntity<Object> bookHall(@PathVariable String city,
      @PathVariable String location, @PathVariable boolean flower,
      @PathVariable boolean catering, @PathVariable boolean music, @PathVariable boolean video) {
    return customerService.bookHall(city, location, flower, catering, music, video);
  }

}