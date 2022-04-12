package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@RequestMapping(value = "/removeAdmin")
	public String removeAdmin(@PathVariable long id) {
		
		return adminService.removeAdmin(id);
		
	}
}
