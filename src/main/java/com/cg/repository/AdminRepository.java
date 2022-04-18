package com.cg.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{

	List<Admin> findByAdminFirstName(String firstName);

	List<Admin> findByAdminLastName(String lastName);

	Admin findByAdminContact(String adminContact);
	
	Admin findByAdminEmail(String email);

	Admin findByAdminEmailAndAdminPassword(String email, String password);
	
}
