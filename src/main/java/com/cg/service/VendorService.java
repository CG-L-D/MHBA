package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.entity.Customer;
import com.cg.entity.Admin;
import com.cg.entity.Vendor;
import com.cg.repository.CustomerRepository;
import com.cg.repository.VendorRepository;

@Service
public class VendorService {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private VendorRepository vendorRepo;
	
	public String addVendor(Vendor vendor)
	{
		vendorRepo.save(vendor);
		return "Vendor Added Successfully..";
	}
	

	public String removeAllVendor() {
		
		vendorRepo.deleteAll();
		return "All vendor deleted successfully.";
	}
	
	public String removeVendorById(int id) {
		
		if(vendorRepo.existsById(id)) {
			
			vendorRepo.deleteById(id);
			return "Vendor deleted successfully.";
		
		}
		return "Vendor not found.";
	}
	
	public ResponseEntity<Object> getAllVendor() {
	
		List<Vendor> vendor = vendorRepo.findAll();
		
		if(vendor == null) {
			return new ResponseEntity<Object>("Vendor not found.", HttpStatus.OK);

		}
		return new ResponseEntity<Object>(vendor, HttpStatus.OK);
	}
	
	public ResponseEntity<Object> getVendorByPage(int m, int n) {

		Pageable page = PageRequest.of(m, n);
		
		Page<Vendor> vendor= vendorRepo.findAll(page);

		if(vendor == null) {

			return new ResponseEntity<Object>("Vendor not found.", HttpStatus.OK);

		}
		return new ResponseEntity<Object>(vendor, HttpStatus.OK);
	}
	
	public ResponseEntity<Object> getVendorById(int id) {

		Optional<Vendor> vendor= vendorRepo.findById(id);
		
		if(vendor == null) {

			return new ResponseEntity<Object>("Vendor not found.", HttpStatus.OK);

		}
		return new ResponseEntity<Object>(vendor, HttpStatus.OK);
		
	}
	
	public ResponseEntity<Object> getVendorByFirstName(String firstName){
		
		List<Admin> vendor = vendorRepo.findByFirstName(firstName);
		
		if(vendor == null ) {

			return new ResponseEntity<Object>("Vendor not found.", HttpStatus.OK);

		}
		return new ResponseEntity<Object>(vendor, HttpStatus.OK);
				
	}
	
	public ResponseEntity<Object> getVendorByLastName(String lastName){
		
		List<Admin> vendor = vendorRepo.findByLastName(lastName);
		
		if(vendor == null ) {

			return new ResponseEntity<Object>("Vendor not found.", HttpStatus.OK);

		}
		return  new ResponseEntity<Object>(vendor, HttpStatus.OK);
				
	}
	
	public ResponseEntity<Object> getByVendorContact(String adminContact){
		
		Vendor vendor = vendorRepo.findByVendorContact(adminContact);
		
		if(vendor == null ) {

			return new ResponseEntity<Object>("Vendor not found.", HttpStatus.OK);

			
		}
		return new ResponseEntity<Object>(vendor, HttpStatus.OK);
				
	}
	
	public ResponseEntity<Object> getVendorByType(String type) {

		List<Vendor> vendor= vendorRepo.findByType(type);
		
		if(vendor == null) {

			return new ResponseEntity<Object>("Vendor not found.", HttpStatus.OK);

		}
		return new ResponseEntity<Object>(vendor, HttpStatus.OK);
		
	}

	public ResponseEntity<Object> bookVendor(int customerId, boolean flower,boolean catering,boolean video,boolean music){
		
		List<Vendor> vendors = vendorRepo.findByServices(flower, catering, video, music);

		if(vendors != null){
			for(Vendor v:vendors) {
			  if(v.isAvailable()) {
				  	
					v.setAvailable(false);
					((Customer) customerRepository.findById(customerId)).setVendor(v.getVendorId());

					return new ResponseEntity<Object>("Vendor booked Successfully", HttpStatus.OK);
			  }

			}
			return new ResponseEntity<Object>("All vendors are booked.", HttpStatus.OK);
		}
		return new ResponseEntity<Object>("No vendor available providing required services.", HttpStatus.OK);
	}
	
	
}

