package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.Admin;
import com.cg.entity.Supervisor;

@Repository
public interface SupervisorRepository extends JpaRepository<Supervisor,Integer>{
	
	Supervisor findByEmailAndPassword(String email, String password);
}
