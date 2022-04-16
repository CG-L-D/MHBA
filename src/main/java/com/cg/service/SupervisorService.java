package com.cg.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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
	public void removeAll() {
		superRepo.deleteAll();
	}
	public void removeById(Integer id) {
		superRepo.deleteById(id);
	}
	public Supervisor getById(Integer id) {
		return superRepo.getById(id);
	}
	public Supervisor getByName(String name) {
		for(Supervisor supervisor:getAllSupervisor()) {
			if(supervisor.getSupervisorName().equalsIgnoreCase(name))
				return supervisor;
		}
		return null;
	}
	public Supervisor getByContact(String contact) {
		for(Supervisor supervisor:getAllSupervisor()) {
			if(supervisor.getSupervisorContact().equalsIgnoreCase(contact))
				return supervisor;
		}
		return null;
	}
	public Supervisor getByEmail(String email) {
		for(Supervisor supervisor:getAllSupervisor()) {
			if(supervisor.getSupervisorEmail().equalsIgnoreCase(email))
				return supervisor;
		}
		return null;
	}
	public List<Supervisor> sortByName() {
		return superRepo.findAll(Sort.by("supervisorName"));
	}
	
}
