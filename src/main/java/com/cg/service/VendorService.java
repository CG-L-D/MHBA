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

import com.cg.entity.Admin;
import com.cg.entity.Vendor;
import com.cg.repository.VendorRepository;

@Service
public class VendorService {
	
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
			
		}
		return new ResponseEntity<Object>(vendor, HttpStatus.OK);
	}
	
	public ResponseEntity<Object> getVendorByPage(int m, int n) {

		Pageable page = PageRequest.of(m, n);
		
		Page<Vendor> vendor= vendorRepo.findAll(page);

		if(vendor == null) {
			
		}
		return new ResponseEntity<Object>(vendor, HttpStatus.OK);
	}
	
	public ResponseEntity<Object> getVendorById(int id) {

		Optional<Vendor> vendor= vendorRepo.findById(id);
		
		if(vendor == null) {
			
		}
		return new ResponseEntity<Object>(vendor, HttpStatus.OK);
		
	}
	
	public List<ResponseEntity<Object>> getVendorByFirstName(String firstName){
		
		List<Admin> vendor = vendorRepo.findByFirstName(firstName);
		
		if(vendor == null ) {
			
		}
		return (List<ResponseEntity<Object>>) new ResponseEntity<Object>(vendor, HttpStatus.OK);
				
	}
	
	public List<ResponseEntity<Object>> getVendorByLastName(String lastName){
		
		List<Admin> vendor = vendorRepo.findByLastName(lastName);
		
		if(vendor == null ) {
			
		}
		return (List<ResponseEntity<Object>>) new ResponseEntity<Object>(vendor, HttpStatus.OK);
				
	}
	
	public ResponseEntity<Object> getByVendorContact(String adminContact){
		
		Vendor vendor = vendorRepo.findByVendorContact(adminContact);
		
		if(vendor == null ) {
			
		}
		return new ResponseEntity<Object>(vendor, HttpStatus.OK);
				
	}
	
	public List<ResponseEntity<Object>> getVendorSortedByFirstName() {

		List<Vendor> vendor = vendorRepo.findAll(Sort.by("firstName"));

		if(vendor == null) {
			
		}
		return (List<ResponseEntity<Object>>) new ResponseEntity<Object>(vendor, HttpStatus.OK);
	}
	
	public List<ResponseEntity<Object>> getVendorSortedByLastName() {

		List<Vendor> vendor = vendorRepo.findAll(Sort.by("lastName"));

		if(vendor == null) {
			
		}
		return (List<ResponseEntity<Object>>) new ResponseEntity<Object>(vendor, HttpStatus.OK);
	}
	
	
}

