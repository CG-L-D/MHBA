package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Hall;
import com.cg.entity.Supervisor;
import com.cg.service.SupervisorService;

@RestController
public class SupervisorController {
	
	@Autowired
	private SupervisorService supervisorService;
	

	   @RequestMapping(value = "/loginSupervisor/{email}/{password}")
	   public ResponseEntity<Object> loginSupervisor(@PathVariable String email, @PathVariable String password){
		   return supervisorService.loginSupervisor(email, password);
	   }
	   
	    @RequestMapping(value = "/logoutSupervisor")
	    public ResponseEntity<Object> logoutSupervisor(){
	    	return supervisorService.logoutSupervisor();
	  }
	
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
		  return supervisorService.generateBill(supervisorId);
	  }
	@GetMapping("/addHall")
	public ResponseEntity<Object> addHall(@RequestBody int id, @RequestBody Hall hall){
		return supervisorService.addHall(id, hall);
	}
	
	@GetMapping("/removeHall/{id}")
	public ResponseEntity<Object> removeHall(@PathVariable int id){
		return supervisorService.removeHall(id);
	}
	  
	@GetMapping("/getSupervisorHallDetails/{id}")
	public ResponseEntity<Object> getSupervisorHallDetails(@PathVariable int id){
		return supervisorService.getSupervisorHallDetails(id);
	}

}
