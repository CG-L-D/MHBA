package com.cg.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import com.cg.entity.Admin;
import com.cg.entity.Hall;
import com.cg.entity.Supervisor;
import com.cg.entity.Vendor;
import com.cg.repository.AdminRepository;
import com.cg.service.AdminService;
import com.cg.MhbaApplicationTests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

class AdminServiceTest extends MhbaApplicationTests {

	@MockBean
	AdminRepository adminRepository;

	@Autowired
	AdminService adminService;

	Admin admin;
	Supervisor supervisor;
	Vendor vendor;
	Hall hall;

	@BeforeEach
	void setUp() {

		admin = new Admin(101, "Onkar", "Magadum", "onkarmagadum@gmail.com", "9000000000", "Abc@123");

	}

	@Test
	public void testLoginAdmin() {

		when(adminRepository.findByAdminEmailAndAdminPassword("onkarmagadum@gmail.com",
				"Abc@123"))
				.thenReturn(admin);

		assertEquals("<200 OK OK,Admin login successfull.,[]>",
				adminService.loginAdmin("onkarmagadum@gmail.com", "Abc@123").toString());

	}

	@Test
	public void testLogoutAdmin() {

		when(adminRepository.findByAdminEmailAndAdminPassword("onkarmagadum@gmail.com",
				"Abc@123"))
				.thenReturn(admin);

		adminService.loginAdmin("onkarmagadum@gmail.com", "Abc@123");

		assertEquals("<200 OK OK,Admin logout successfull.,[]>",
				adminService.logoutAdmin().toString());

	}

	// @Test
	public void testAddAdmin() {

		adminRepository.save(admin);

		assertEquals("<200 OK OK,Admin added successfully.,[]>",
				adminService.addAdmin(admin).toString());

	}

	// @Test
	public void testGetAdmin() {

		when(adminRepository.findByAdminEmailAndAdminPassword("onkarmagadum@gmail.com", "Abc@123")).thenReturn(admin);

		adminService.loginAdmin("onkarmagadum@gmail.com", "Abc@123");

		assertEquals("<200 OK OK," + admin + ",[]>",
				adminService.getAdmin().toString());

	}

	// @Test
	public void testGetAdminRevenue() {
		when(adminRepository.findByAdminEmailAndAdminPassword("onkarmagadum@gmail.com",
				"Abc@123"))
				.thenReturn(admin);

		adminService.loginAdmin("onkarmagadum@gmail.com", "Abc@123");

		assertEquals("<200 OK OK,Revenue for admin with ID: 101 is:0.0,[]>",
				adminService.getAdminRevenue().toString());

	}

	// @Test
	public void testCollectAdminRevenue() {

		assertEquals("<200 OK OK,Admin revenue collected.,[]>",
				adminService.collectAdminRevenue().toString());

	}

}
