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

		return adminService.getByAdminPage(m, n);

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

	@RequestMapping(value = "/getAdminRevenue")
	public ResponseEntity<Object> getAdminRevenue() {

		return adminService.getAdminRevenue();

	}

	@RequestMapping(value = "/getAdminRevenueById/{adminId}")
	public ResponseEntity<Object> getAdminRevenueById(@PathVariable int adminId) {

		return adminService.getAdminRevenueById(adminId);

	}
	
	@RequestMapping(value = "/collectAdminRevenue")
	public ResponseEntity<Object> collectAdminRevenue() {

		return adminService.collectAdminRevenue();

	}

	@RequestMapping(value = "/getSortedByAdminFirstName")
	public ResponseEntity<Object> getSortedByAdminFirstName() {

		return adminService.getSortedByAdminFirstName();

	}

	@RequestMapping(value = "/getSortedByAdminLastName")
	public ResponseEntity<Object> getSortedByAdminLastName() {

		return adminService.getSortedByAdminLastName();

	}

	@RequestMapping(value = "/getSortedByAdminRevenue")
	public ResponseEntity<Object> getSortedByAdminRevenue() {

		return adminService.getSortedByAdminRevenue();

	}

	@RequestMapping(value = "/makeAdminActive/{adminId}")
	public ResponseEntity<Object> makeAdminActive(@PathVariable int adminId) {

		return adminService.makeAdminActive(adminId);

	}

	@RequestMapping(value = "/makeAdminDeactive/{adminId}")
	public ResponseEntity<Object> makeAdminDeactive(@PathVariable int adminId) {

		return adminService.makeAdminDeactive(adminId);

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

	@RequestMapping(value = "/getBySupervisorName")
	public ResponseEntity<Object> getBySupervisorName(@RequestBody String  name) {

		return adminService.getBySupervisorName(name);

	}

	@RequestMapping(value = "/getBySupervisorContact")
	public ResponseEntity<Object> getBySupervisorContact(@RequestBody String contact) {

		return adminService.getBySupervisorContact(contact);

	}

	@RequestMapping(value = "/getBySupervisorEmail")
	public ResponseEntity<Object> getBySupervisorEmail(@RequestBody String email) {

		return adminService.getBySupervisorEmail(email);

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

	@RequestMapping(value = "/getByVendorFirstName")
	public ResponseEntity<Object> getByVendorFirstName(@RequestBody String firstName) {

		return adminService.getByVendorFirstName(firstName);

	}

	@RequestMapping(value = "/getByVendorLastName")
	public ResponseEntity<Object> getByVendorLastName(@RequestBody String lastName) {

		return adminService.getByVendorLastName(lastName);

	}

	@RequestMapping(value = "/getByVendorContact")
	public ResponseEntity<Object> getByVendorContact(@RequestBody String vendorContact) {

		return adminService.getByVendorContact(vendorContact);

	}

}
