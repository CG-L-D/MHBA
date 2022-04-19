package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.cg.entity.Admin;
import com.cg.entity.Supervisor;

@Repository
public interface SupervisorRepository extends JpaRepository<Supervisor,Integer>{
	
	Supervisor findByEmailAndPassword(String email, String password);

	List<Supervisor> findBySupervisorName(String name);

	List<Supervisor> findBySupervisorContact(String contact);

	List<Supervisor> findBySupervisorEmail(String email);

}
