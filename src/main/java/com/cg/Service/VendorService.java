package com.cg.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
	
	
	
	public List<Vendor> getAll()
	{
		return vendorRepo.findAll();
	}
	
	
	
	
}

