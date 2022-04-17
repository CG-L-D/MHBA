package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Vendor;
import com.cg.service.VendorService;

@RestController
public class AdminVendorController {
	
	@Autowired
	VendorService vendorService;

	@PostMapping("/addVendor")
	public String addVendor(@RequestBody Vendor vendor)
	{
		return vendorService.addVendor(vendor);
		
	}

	@RequestMapping(value = "/removeAllVendor")
	public String removeAllVendor() {
		
		return vendorService.removeAllVendor();
		
	}
	
	@RequestMapping(value = "/removeVendorById/{id}")
	public String removeVendorById(@PathVariable int id) {
		
		return vendorService.removeVendorById(id);
		
	}
	
	@RequestMapping(value = "/getAllVendor")
	public ResponseEntity<Object> getAllVendor() {
		
		return vendorService.getAllVendor();
	
	}
	
	@RequestMapping(value = "/getVendorByPage/{m}/{n}")
	public ResponseEntity<Object> getVendorByPage(@PathVariable int m, @PathVariable int n) {
		
		return vendorService.getVendorByPage(m,n);
	
	}
	
	@RequestMapping(value = "/getVendorById/{id}")
	public ResponseEntity<Object> getVendorById(@PathVariable int id) {
		
		return vendorService.getVendorById(id);
	
	}
	
	@RequestMapping(value = "/getVendorByFirstName")
	public ResponseEntity<Object> getVendorByFirstName(@RequestBody String firstName) {
		
		return vendorService.getVendorByFirstName(firstName);
	
	}

	@RequestMapping(value = "/getVendorByLastName")
	public ResponseEntity<Object> getVendorByLastName(@RequestBody String lastName) {
		
		return vendorService.getVendorByLastName(lastName);
	
	}

	@RequestMapping(value = "/getByVendorContact")
	public ResponseEntity<Object> getVendorByContactNumber(@RequestBody String vendorContact) {
		
		return vendorService.getByVendorContact(vendorContact);
	
	}
	
	
	
	
}
