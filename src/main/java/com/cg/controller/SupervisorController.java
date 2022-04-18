package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Supervisor;
import com.cg.service.SupervisorService;

@RestController
public class SupervisorController {
	
	@Autowired
	private SupervisorService supervisorService;
	
	@PostMapping("/addSupervisor")
	  public ResponseEntity<Object> addSupervisor(@RequestBody Supervisor s) {
	    return supervisorService.addSupervisor(s);
	  }

	  @GetMapping("/getAllSupervisors")
	  public ResponseEntity<Object> getAllSupervisors() {
	    return supervisorService.getAllSupervisor();
	  }

	  @DeleteMapping("/removeSupervisor/{id}")
	  public ResponseEntity<Object> removeSupervisor(@PathVariable int id) {
	    return supervisorService.removeById(id);
	  }
	  
	  @GetMapping("/getHallDetailsForSupervisor/{id}")
	  public ResponseEntity<Object> getHallDetailsForSupervisor(@PathVariable int id){
		  return supervisorService.getHallDetailsForSupervisor(id);
	  }
	  
	  @GetMapping("/generateBill/{supervisorId}/{vendorId}")
	  public ResponseEntity<Object> generateBill(@PathVariable int supervisorId, @PathVariable int vendorId){
		  return supervisorService.generateBill(supervisorId, vendorId);
	  }

}
