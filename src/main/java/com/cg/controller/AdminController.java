package com.cg.controller;

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
	
	//admin services
	
	@RequestMapping(value = "/loginAdmin/{email}/{password}")
	public ResponseEntity<Object> loginAdmin(@PathVariable String email, @PathVariable String password){
		
		return adminService.loginAdmin(email, password);
		
	}
	
	@RequestMapping(value = "/logoutAdmin")
	public ResponseEntity<Object> logoutAdmin(){
		
		return adminService.logoutAdmin();
		
	}
	
	@RequestMapping(value = "/addAdmin")
	public ResponseEntity<Object> addAdmin(@RequestBody Admin admin) {
		
		return adminService.addAdmin(admin);
		
	}
	
	@RequestMapping(value = "/removeAllAdmin")
	public ResponseEntity<Object> removeAllAdmin() {
		
		return adminService.removeAllAdmin();
		
	}
	
	@RequestMapping(value = "/removeAdminByAdminId/{id}")
	public ResponseEntity<Object> removeAdminByAdminId(@PathVariable int id) {
		
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
	public ResponseEntity<Object> getByAdminContact(@RequestBody String adminContact) {
		
		return adminService.getByAdminContact(adminContact);
	
	}
	
	@RequestMapping(value = "/getAdminByEmail")
	public ResponseEntity<Object> getAdminByEmail(@RequestBody String email) {
		
		return adminService.getAdminByEmail(email);
	
	}
	
	@RequestMapping(value = "/getSortedAdminByFirstName")
	public ResponseEntity<Object> getAdminSortedByFirstName() {
		
		return adminService.getAdminSortedByFirstName();
	
	}
	
	@RequestMapping(value = "/getSortedAdminByLastName")
	public ResponseEntity<Object> getAdminSortedByLastName() {
		
		return adminService.getAdminSortedByLastName();
	
	}

}
