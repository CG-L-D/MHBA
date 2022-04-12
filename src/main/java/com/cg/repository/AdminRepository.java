package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{

	List<Admin> findByFirstName(String firstName);

	List<Admin> findByLastName(String lastName);

	Admin findByContactNumber(String contactNumber);
	
	Admin findByEmail(String email);
	
}
