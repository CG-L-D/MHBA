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
@RequestMapping("/admin")
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
	
	@RequestMapping(value = "/removeByAdminId/{id}")
	public ResponseEntity<Object> removeByAdminId(@PathVariable int id) {
		
		return adminService.removeByAdminId(id);
		
	}
	
	@RequestMapping(value = "/getAllAdmin")
	public ResponseEntity<Object> getAllAdmin() {
		
		return adminService.getAllAdmin();
	
	}
	
	@RequestMapping(value = "/getByAdminPage/{m}/{n}")
	public ResponseEntity<Object> getByAdminPage(@PathVariable int m, @PathVariable int n) {
		
		return adminService.getByAdminPage(m,n);
	
	}
	
	@RequestMapping(value = "/getByAdminId/{id}")
	public ResponseEntity<Object> getByAdminId(@PathVariable int id) {
		
		return adminService.getByAdminId(id);
	
	}
	
	@RequestMapping(value = "/getByAdminFirstName")
	public ResponseEntity<Object> getByAdminFirstName(@RequestBody String firstName) {
		
		return adminService.getByAdminFirstName(firstName);
	
	}
	
	@RequestMapping(value = "/getByAdminLastName")
	public ResponseEntity<Object> getByAdminLastName(@RequestBody String lastName) {
		
		return adminService.getByAdminLastName(lastName);
	
	}

	@RequestMapping(value = "/getByAdminContact")
	public ResponseEntity<Object> getByAdminContact(@RequestBody String adminContact) {
		
		return adminService.getByAdminContact(adminContact);
	
	}
	
	@RequestMapping(value = "/getByAdminEmail")
	public ResponseEntity<Object> getByAdminEmail(@RequestBody String email) {
		
		return adminService.getByAdminEmail(email);
	
	}
	
	@RequestMapping(value = "/getSortedByAdminFirstName")
	public ResponseEntity<Object> getSortedByAdminFirstName() {
		
		return adminService.getSortedByAdminFirstName();
	
	}
	
	@RequestMapping(value = "/getSortedByAdminLastName")
	public ResponseEntity<Object> getSortedByAdminLastName() {
		
		return adminService.getSortedByAdminLastName();
	
	}

}
