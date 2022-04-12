package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Admin;
import com.cg.service.AdminService;

@RestController
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@RequestMapping(value = "/addAdmin")
	public String addAdmin(@RequestBody Admin admin) {
		
		return adminService.addAdmin(admin);
		
	}
	
	@RequestMapping(value = "/removeAllAdmin")
	public String removeAllAdmin() {
		
		return adminService.removeAllAdmin();
		
	}
	
	@RequestMapping(value = "/removeAdminById/{id}")
	public String removeAdmin(@PathVariable int id) {
		
		return adminService.removeAdminById(id);
		
	}
	
	@RequestMapping(value = "/getAllAdmin")
	public ResponseEntity<Object> getAllAdmin() {
		
		return adminService.getAllAdmin();
	
	}
	
	@RequestMapping(value = "/getAdminByPage/{m}/{n}")
	public ResponseEntity<Object> getAdminByPage(@PathVariable int m, @PathVariable int n) {
		
		return adminService.getAdminByPage(m,n);
	
	}
	
	@RequestMapping(value = "/getAdminById/{id}")
	public ResponseEntity<Object> getAdminById(@PathVariable int id) {
		
		return adminService.getAdminById(id);
	
	}
	
	@RequestMapping(value = "/getAdminByFirstName")
	public List<ResponseEntity<Object>> getAdminByFirstName(@RequestBody String firstName) {
		
		return adminService.getAdminByFirstName(firstName);
	
	}
	
	@RequestMapping(value = "/getAdminByLastName")
	public List<ResponseEntity<Object>> getAdminByLastName(@RequestBody String lastName) {
		
		return adminService.getAdminByLastName(lastName);
	
	}

	@RequestMapping(value = "/getByAdminContact")
	public ResponseEntity<Object> getAdminByContactNumber(@RequestBody String adminContact) {
		
		return adminService.getByAdminContact(adminContact);
	
	}
	
	@RequestMapping(value = "/getAdminByEmail")
	public ResponseEntity<Object> getAdminByEmail(@RequestBody String email) {
		
		return adminService.getAdminByEmail(email);
	
	}
	
	@RequestMapping(value = "/getSortedAdminByFirstName")
	public List<ResponseEntity<Object>> getAdminSortedByFirstName() {
		
		return adminService.getAdminSortedByFirstName();
	
	}
	
	@RequestMapping(value = "/getSortedAdminByLastName")
	public List<ResponseEntity<Object>> getAdminSortedByLastName() {
		
		return adminService.getAdminSortedByFirstName();
	
	}
}
