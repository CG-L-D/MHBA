package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.*;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Integer> {

	List<Admin> findByFirstName(String firstName);

	List<Admin> findByLastName(String lastName);

	Vendor findByContactNumber(String contactNumber);

	Vendor findByEmail(String email);

}
