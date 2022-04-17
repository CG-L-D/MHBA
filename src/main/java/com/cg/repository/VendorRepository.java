package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.cg.entity.*;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Integer> {

	List<Admin> findByFirstName(String firstName);

	List<Admin> findByLastName(String lastName);

	Vendor findByVendorContact(String adminContact);
	
	@Query("select vendor from Vendor vendor where vendor.flower=:flower and vendor.catering=:catering and vendor.music=:music and vendor.video=:video")
	List<Vendor> findByServices(
			@Param("flower") boolean flower, 
			@Param("catering") boolean catering,
			@Param("video") boolean video,
			@Param("music") boolean music
			);

	// boolean bookVendor(int hallId, boolean flower,boolean catering,boolean video,boolean music);
	
}
