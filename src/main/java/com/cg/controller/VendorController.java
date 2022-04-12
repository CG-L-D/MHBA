package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Vendor;
import com.cg.service.VendorService;

@RestController
public class VendorController {

	@Autowired
	private VendorService vendorService;
	
	@PostMapping("/addV")
	public String addVendor(@RequestBody Vendor vendor)
	{
		return vendorService.addVendor(vendor);
		
	}
	
	
	@GetMapping("/getAll")
	public List<Vendor> getAll()
	{
		return vendorService.getAll();
	}
	
	
}
