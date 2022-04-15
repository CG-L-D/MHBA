package com.cg.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.cg.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{

	List<Admin> findByFirstName(String firstName);

	List<Admin> findByLastName(String lastName);

	Admin findByAdminContact(String adminContact);
	
	Admin findByEmail(String email);
	
}
