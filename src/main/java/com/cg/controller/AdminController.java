package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Admin;
import com.cg.entity.Supervisor;
import com.cg.entity.Vendor;
import com.cg.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService adminService;

	// admin services

	@RequestMapping(value = "/loginAdmin/{email}/{password}")
	public ResponseEntity<Object> loginAdmin(@PathVariable String email, @PathVariable String password) {

		return adminService.loginAdmin(email, password);

	}

	@RequestMapping(value = "/logoutAdmin")
	public ResponseEntity<Object> logoutAdmin() {

		return adminService.logoutAdmin();

	}

	@RequestMapping(value = "/addAdmin")
	public ResponseEntity<Object> addAdmin(@RequestBody Admin admin) {

		return adminService.addAdmin(admin);

	}

	@RequestMapping(value = "/removeAdmin")
	public ResponseEntity<Object> removeAdmin() {

		return adminService.removeAdmin();

	}

	@RequestMapping(value = "/getAdmin")
	public ResponseEntity<Object> getAdmin() {

		return adminService.getAdmin();

	}
	
	@RequestMapping(value = "/getAdminRevenue")
	public ResponseEntity<Object> getAdminRevenue() {

		return adminService.getAdminRevenue();

	}
	
	@RequestMapping(value = "/collectAdminRevenue")
	public ResponseEntity<Object> collectAdminRevenue() {

		return adminService.collectAdminRevenue();

	}
	
	@RequestMapping(value = "/addSupervisor")
	public ResponseEntity<Object> addSupervisor(@RequestBody Supervisor supervisor) {

		return adminService.addSupervisor(supervisor);

	}
	
	@RequestMapping(value = "/removeAllSupervisor")
	public ResponseEntity<Object> removeAllSupervisor() {

		return adminService.removeAllSupervisor();

	}

	@RequestMapping(value = "/removeBySupervisorId/{id}")
	public ResponseEntity<Object> removeBySupervisorId(@PathVariable int id) {

		return adminService.removeBySupervisorId(id);

	}

	@RequestMapping(value = "/getAllSupervisor")
	public ResponseEntity<Object> getAllSupervisor() {

		return adminService.getAllSupervisor();

	}

	@RequestMapping(value = "/getBySupervisorId/{id}")
	public ResponseEntity<Object> getBySupervisorId(@PathVariable int id) {

		return adminService.getBySupervisorId(id);

	}

	@RequestMapping(value = "/getSortedBySupervisorName")
	public ResponseEntity<Object> getSortedBySupervisorName() {

		return adminService.getSortedBySupervisorName();

	}
	
	
	//vendor controller
	@RequestMapping(value = "/addVendor")
	public ResponseEntity<Object> addVendor(@RequestBody Vendor vendor) {

		return adminService.addVendor(vendor);

	}

	@RequestMapping(value = "/removeAllVendor")
	public ResponseEntity<Object> removeAllvendor() {

		return adminService.removeAllVendor();

	}

	@RequestMapping(value = "/removeByVendorId/{id}")
	public ResponseEntity<Object> removeByVendorId(@PathVariable int id) {

		return adminService.removeByVendorId(id);

	}

	@RequestMapping(value = "/getAllVendor")
	public ResponseEntity<Object> getAllVendor() {

		return adminService.getAllVendor();

	}

	@RequestMapping(value = "/getByVendorPage/{m}/{n}")
	public ResponseEntity<Object> getByVendorPage(@PathVariable int m, @PathVariable int n) {

		return adminService.getByVendorPage(m, n);

	}

	@RequestMapping(value = "/getByVendorId/{id}")
	public ResponseEntity<Object> getByVendorId(@PathVariable int id) {

		return adminService.getByVendorId(id);

	}

	@RequestMapping(value = "/getAllCustomers")
	public ResponseEntity<Object> getAllCustomers() {

		return adminService.getAllCustomers();
		
	}

	@RequestMapping(value = "/removeCustomerById/{id}")
	public ResponseEntity<Object> removeCustomerById(@PathVariable int id){

		return adminService.removeCustomerById(id);

	}

}
