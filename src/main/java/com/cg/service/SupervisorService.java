package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.entity.Vendor;

import com.cg.entity.Hall;
import com.cg.entity.Supervisor;
import com.cg.repository.HallRepository;
import com.cg.repository.SupervisorRepository;
import com.cg.repository.VendorRepository;

@Service
public class SupervisorService {

	@Autowired
	private VendorRepository vendorRepository;

	@Autowired
	private HallRepository hallRepository;
	
	@Autowired
	private SupervisorRepository supervisorRepository;
	
	Supervisor currentSupervisor = new Supervisor();
	
	public ResponseEntity<Object> loginSupervisor(String email, String password){
		if((currentSupervisor = supervisorRepository.findByEmailAndPassword(email, password)) != null){
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
		supervisorRepository.save(s);
		  return new ResponseEntity<Object>("Supervisor added successfully", HttpStatus.OK);
	}
	public ResponseEntity<Object> getAllSupervisor(){
		  return new ResponseEntity<Object>(supervisorRepository.findAll(), HttpStatus.OK);
	  }
	public ResponseEntity<Object> removeAll() {
		supervisorRepository.deleteAll();
		return new ResponseEntity<Object>("Removed all supervisors", HttpStatus.OK );
	}
	public ResponseEntity<Object> removeById(Integer id) {
		supervisorRepository.deleteById(id);
		return new ResponseEntity<Object>("Supervisor removed", HttpStatus.OK);
	}
	public ResponseEntity<Object> getById(Integer id) {
		return new ResponseEntity<Object>(supervisorRepository.getById(id), HttpStatus.OK);
	}
	public ResponseEntity<Object> getByName(String name) {
		for(Supervisor supervisor:supervisorRepository.findAll()) {
			if(supervisor.getSupervisorName().equalsIgnoreCase(name))
				return new ResponseEntity<Object>(supervisor, HttpStatus.OK);
		}
		return new ResponseEntity<Object>("No supervisor found", HttpStatus.OK);
		
	public ResponseEntity<Object> addHall(int id, Hall hall) {
		supervisorRepository.getById(id).setHall(hall);
		return new ResponseEntity<Object>("Hall added successfully.", HttpStatus.OK);
	}

	public ResponseEntity<Object> removeHall(int id) {
		supervisorRepository.deleteById(id);
		return new ResponseEntity<Object>("Hall deleted successfully.", HttpStatus.OK);
	}

	public ResponseEntity<Object> getSupervisorHallDetails() {
		Hall hall = currentSupervisor.getHall();
		if (hall == null) {
			return new ResponseEntity<Object>("Currently, no hall is assigned to supervisor.", HttpStatus.OK);
		}
		return new ResponseEntity<Object>("No supervisor found", HttpStatus.OK);
	}
	public ResponseEntity<Object> sortByName() {
		return new ResponseEntity<Object>(supervisorRepository.findAll(Sort.by("supervisorName")), HttpStatus.OK);
	}
	
	public ResponseEntity<Object> getHallDetailsForSupervisor(){
		if( currentSupervisor != null ) {
			Hall hall = currentSupervisor.getHall();
			return new ResponseEntity<Object>(hall.toString() ,HttpStatus.OK);
		}else {
			return new ResponseEntity<Object>("Error, currently no admin logged-in.", HttpStatus.BAD_REQUEST);
		}
	}
	
	public ResponseEntity<Object> generateBill(int hallId, boolean flower, boolean catering, boolean music, boolean video) {

		if( currentSupervisor != null ) {
		double billAmount = 0.0;
		Hall hall = hallRepository.getById(hallId);
		billAmount += hall.getHallPrice();
		List<Vendor> vendors = vendorRepository.findByServices(flower, catering, music, video);
		billAmount += vendors.get(0).getVendorCost();
		billAmount *= 1.18;
		return new ResponseEntity<Object>(billAmount, HttpStatus.OK);
		}else {
			return new ResponseEntity<Object>("Error, currently no admin logged-in.", HttpStatus.BAD_REQUEST);
		}

	}
}
