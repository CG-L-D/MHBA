package com.cg.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Customer;
import com.cg.entity.Supervisor;
import com.cg.repository.SupervisorRepository;


@Service
public class SupervisorService {
	@Autowired
	private SupervisorRepository superRepo;
	
	public String addSupervisor(Supervisor s) {
		  superRepo.save(s);
		  return "Supervisor added successfully";
	}
	public List<Supervisor> getAllSupervisor(){
		  return superRepo.findAll();
	  }
}
