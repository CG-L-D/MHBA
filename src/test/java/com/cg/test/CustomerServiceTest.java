package com.cg.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import com.cg.entity.Admin;
import com.cg.entity.Customer;
import com.cg.entity.Hall;
import com.cg.entity.HallOffers;
import com.cg.entity.Supervisor;
import com.cg.entity.Vendor;
import com.cg.repository.CustomerRepository;
import com.cg.repository.AdminRepository;
import com.cg.repository.HallRepository;
import com.cg.repository.SupervisorRepository;
import com.cg.MhbaApplicationTests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import net.bytebuddy.implementation.bind.annotation.Super;

import com.cg.service.CustomerService;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import com.cg.service.VendorService;
import com.cg.service.AdminService;
import com.cg.service.SupervisorService;

class CustomerServiceTest extends MhbaApplicationTests {

	@MockBean
	CustomerRepository customerRepository;

	@MockBean
	SupervisorRepository supervisorRepository;

	@MockBean
	AdminRepository adminRepository;

	@Autowired
	SupervisorService supervisorService;

	@Autowired
	CustomerService customerService;

	@Autowired
	AdminService adminService;

	Customer customer;
	Hall hall;
	Admin admin;
	List<HallOffers> hallOffers;
	Supervisor supervisor;
	Vendor vendor;

	@BeforeEach
	void setUp() {
		admin = new Admin(101, "Onkar", "Magadum", "onkarmagadum@gmail.com", "9000000000", "Abc@123");
		customer = new Customer(501, "Kaustubh Chillure", "kaustubh@gmail.com", "Abc@123", "9000000000");
	}

	@Test
	final void testLoginCustomer() {

		when(customerRepository.findByCustomerEmailAndCustomerPassword("kaustubh@gmail.com",
				"Abc@123"))
				.thenReturn(customer);

		assertEquals("<200 OK OK,Customer login successfull.,[]>",
				customerService.loginCustomer("kaustubh@gmail.com", "Abc@123").toString());
	}

	@Test
	final void testLogoutCustomer() {
		when(customerRepository.findByCustomerEmailAndCustomerPassword("kaustubh@gmail.com",
				"Abc@123"))
				.thenReturn(customer);

		customerService.loginCustomer("kaustubh@gmail.com", "Abc@123");

		assertEquals("<200 OK OK,Customer logout successfull.,[]>",
				customerService.logoutCustomer().toString());
	}

	@Test
	final void testAddCustomer() {

		customerRepository.save(customer);

		assertEquals("<200 OK OK,Customer Added successfully,[]>",
				customerService.addCustomer(customer).toString());
	}

	@Test
	final void testBookHall() {

		when(customerRepository.findByCustomerEmailAndCustomerPassword("kaustubh@gmail.com",
				"Abc@123")).thenReturn(customer);

		when(adminRepository.findByAdminEmailAndAdminPassword("onkarmagadum@gmail.com",
				"Abc@123")).thenReturn(admin);

		// assertEquals("<200 OK OK,Admin login successfull.,[]>",
		// adminService.loginAdmin("onkarmagadum@gmail.com", "Abc@123").toString());

		adminService.loginAdmin("onkarmagadum@gmail.com", "Abc@123");

		hallOffers = new ArrayList<HallOffers>();

		hallOffers.add(new HallOffers(1001, "electrical", "Lights", true));
		hallOffers.add(new HallOffers(1002, "electrical", "AC", true));
		hallOffers.add(new HallOffers(1003, "dining", "Veg", true));
		hallOffers.add(new HallOffers(1004, "sound", "Dolby", true));

		hall = new Hall(301, "NewHall", 40, 500, "CivilLine", "City", 70000, false,
				null, hallOffers);

		supervisor = new Supervisor(201, "SupervisorName",
				"supervisoremail@gmail.com", "9000000000", hall);
		adminService.addSupervisor(supervisor);

		vendor = new Vendor(201, "FirstName", "LastName", "9000000000", true, true,
				true, true, true);
		adminService.addVendor(vendor);

		customerService.loginCustomer("kaustubh@gmail.com", "Abc@123");
		assertEquals("<200 OK OK,Hall and vendor boooked successfully, your bill amount is: 109740.0,[]>",
				customerService.BookHall(501, "City", "CivilLine", true, true, true, true));
	}

}
