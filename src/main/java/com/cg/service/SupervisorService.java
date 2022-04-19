package com.cg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.entity.Hall;
import com.cg.entity.Supervisor;
import com.cg.entity.Vendor;
import com.cg.repository.HallRepository;
import com.cg.repository.SupervisorRepository;


@Service
public class SupervisorService {
	@Autowired
	private SupervisorRepository superRepo;
	
	@Autowired
	private HallRepository hallRepository;
	
	Supervisor currentSupervisor = new Supervisor();
	
	public ResponseEntity<Object> loginSupervisor(String email, String password){
		if((currentSupervisor = superRepo.findByEmailAndPassword(email, password)) != null){
			return new ResponseEntity<Object>("Supervisor login successful.", HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Supervisor login failed, invalid credentials.", HttpStatus.FORBIDDEN);
	}
	
	public ResponseEntity<Object> logoutSupervisor(){
		if(currentSupervisor != null){
			currentSupervisor = null;
			return new ResponseEntity<Object>("Supervisor logout successful.", HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Error, currently no Supervisor logged-in.", HttpStatus.BAD_REQUEST);
	}
	
	public ResponseEntity<Object> addSupervisor(Supervisor s) {
		  superRepo.save(s);
		  return new ResponseEntity<Object>("Supervisor added successfully", HttpStatus.OK);
	}
	public ResponseEntity<Object> getAllSupervisor(){
		  return new ResponseEntity<Object>(superRepo.findAll(), HttpStatus.OK);
	  }
	public ResponseEntity<Object> removeAll() {
		superRepo.deleteAll();
		return new ResponseEntity<Object>("Removed all supervisors", HttpStatus.OK );
	}
	public ResponseEntity<Object> removeById(Integer id) {
		superRepo.deleteById(id);
		return new ResponseEntity<Object>("Supervisor removed", HttpStatus.OK);
	}
	public ResponseEntity<Object> getById(Integer id) {
		return new ResponseEntity<Object>(superRepo.getById(id), HttpStatus.OK);
	}
	public ResponseEntity<Object> getByName(String name) {
		for(Supervisor supervisor:superRepo.findAll()) {
			if(supervisor.getSupervisorName().equalsIgnoreCase(name))
				return new ResponseEntity<Object>(supervisor, HttpStatus.OK);
		}
		return new ResponseEntity<Object>("No supervisor found", HttpStatus.OK);
	}
	public ResponseEntity<Object> getByContact(String contact) {
		for(Supervisor supervisor:superRepo.findAll()) {
			if(supervisor.getSupervisorContact().equalsIgnoreCase(contact))
				return new ResponseEntity<Object>(supervisor, HttpStatus.OK);
		}
		return new ResponseEntity<Object>("No supervisor found", HttpStatus.OK);
	}
	public ResponseEntity<Object> getByEmail(String email) {
		for(Supervisor supervisor:superRepo.findAll()) {
			if(supervisor.getSupervisorEmail().equalsIgnoreCase(email))
				return new ResponseEntity<Object>(supervisor, HttpStatus.OK);
		}
		return new ResponseEntity<Object>("No supervisor found", HttpStatus.OK);
	}
	public ResponseEntity<Object> sortByName() {
		return new ResponseEntity<Object>(superRepo.findAll(Sort.by("supervisorName")), HttpStatus.OK);
	}
	
	public ResponseEntity<Object> getHallDetailsForSupervisor(int id){
		Supervisor supervisor = superRepo.getById(id);
		int hallId = supervisor.getHallId();
		Hall hall = hallRepository.getById(hallId);
		return new ResponseEntity<Object>(hall.toString(), HttpStatus.OK);
	}
	
	public ResponseEntity<Object> generateBill(int supervisorId){
		double billAmount = 0.0;
		Supervisor supervisor = superRepo.getById(supervisorId);
		int hallId = supervisor.getHallId();
		Hall hall = hallRepository.getById(hallId);
		billAmount += hall.getPrice();
		Vendor vendor = hall.getVendor();
		billAmount += vendor.getVendorCost();
		billAmount *= 1.18;
		return new ResponseEntity<Object>(billAmount, HttpStatus.OK);
	}

}

