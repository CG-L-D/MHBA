package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Admin;
import com.cg.entity.Vendor;
import com.cg.service.AdminService;
import com.cg.service.VendorService;

@RestController
public class AdminController {

	@Autowired
	AdminService adminService;
	
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
	public List<ResponseEntity<Object>> getVendorByFirstName(@RequestBody String firstName) {
		
		return vendorService.getVendorByFirstName(firstName);
	
	}
	

	@RequestMapping(value = "/getVendorByLastName")
	public List<ResponseEntity<Object>> getVendorByLastName(@RequestBody String lastName) {
		
		return vendorService.getVendorByLastName(lastName);
	
	}

	@RequestMapping(value = "/getByVendorContact")
	public ResponseEntity<Object> getVendorByContactNumber(@RequestBody String vendorContact) {
		
		return vendorService.getByVendorContact(vendorContact);
	
	}
	@RequestMapping(value = "/getSortedVendorByFirstName")
	public List<ResponseEntity<Object>> getVendorSortedByFirstName() {
		
		return vendorService.getVendorSortedByFirstName();
	
	}
	
	@RequestMapping(value = "/getSortedVendorByLastName")
	public List<ResponseEntity<Object>> getVendorSortedByLastName() {
		
		return vendorService.getVendorSortedByLastName();
	
	}

	
	
	
	
	//admin service
	
	
	
	@RequestMapping(value = "/addAdmin")
	public ResponseEntity<Object> addAdmin(@RequestBody Admin admin) {
		
		return adminService.addAdmin(admin);
		
	}
	
	@RequestMapping(value = "/removeAllAdmin")
	public String removeAllAdmin() {
		
		return adminService.removeAllAdmin();
		
	}
	
	@RequestMapping(value = "/removeAdminByAdminId/{id}")
	public String removeAdminByAdminId(@PathVariable int id) {
		
		return adminService.removeAdminByAdminId(id);
		
	}
	
	@RequestMapping(value = "/getAllAdmin")
	public ResponseEntity<Object> getAllAdmin() {
		
		return adminService.getAllAdmin();
	
	}
	
	@RequestMapping(value = "/getAdminByPage/{m}/{n}")
	public ResponseEntity<Object> getAdminByPage(@PathVariable int m, @PathVariable int n) {
		
		return adminService.getAdminByPage(m,n);
	
	}
	
	@RequestMapping(value = "/getAdminByAdminId/{id}")
	public ResponseEntity<Object> getAdminByAdminId(@PathVariable int id) {
		
		return adminService.getAdminByAdminId(id);
	
	}
	
	@RequestMapping(value = "/getAdminByFirstName")
	public ResponseEntity<Object> getAdminByFirstName(@RequestBody String firstName) {
		
		return adminService.getAdminByFirstName(firstName);
	
	}
	
	@RequestMapping(value = "/getAdminByLastName")
	public ResponseEntity<Object> getAdminByLastName(@RequestBody String lastName) {
		
		return adminService.getAdminByLastName(lastName);
	
	}

	@RequestMapping(value = "/getByAdminContact")
<<<<<<< Updated upstream
	public ResponseEntity<Object> getByAdminContact(@RequestBody String adminContact) {
		
		return adminService.getByContact(adminContact);
=======
	public ResponseEntity<Object> getAdminByContactNumber(@RequestBody String adminContact) {
		
		return adminService.getByAdminContact(adminContact);
>>>>>>> Stashed changes
	
	}
	
	@RequestMapping(value = "/getAdminByEmail")
	public ResponseEntity<Object> getAdminByEmail(@RequestBody String email) {
		
		return adminService.getAdminByEmail(email);
	
	}
	
	@RequestMapping(value = "/getSortedAdminByFirstName")
<<<<<<< Updated upstream
	public ResponseEntity<Object> getAdminSortedByFirstName() {
=======
	public List<ResponseEntity<Object>> getAdminSortedByFirstName() {
>>>>>>> Stashed changes
		
		return adminService.getAdminSortedByFirstName();
	
	}
	
	@RequestMapping(value = "/getSortedAdminByLastName")
<<<<<<< Updated upstream
	public ResponseEntity<Object> getAdminSortedByLastName() {
=======
	public List<ResponseEntity<Object>> getAdminSortedByLastName() {
>>>>>>> Stashed changes
		
		return adminService.getAdminSortedByLastName();
	
	}
}
