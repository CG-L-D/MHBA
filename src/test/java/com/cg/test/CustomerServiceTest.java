package com.cg.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.text.SimpleDateFormat;
import com.cg.entity.Admin;
import com.cg.entity.Customer;
import com.cg.entity.Hall;
import com.cg.entity.HallOffers;
import com.cg.entity.Supervisor;
import com.cg.entity.Vendor;
import com.cg.repository.CustomerRepository;
import com.cg.repository.AdminRepository;
import com.cg.repository.SupervisorRepository;
import com.cg.MhbaApplicationTests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.cg.service.CustomerService;
import java.util.List;
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
		customer = new Customer(501, "Kaustubh Chillure", "kaustubh@gmail.com", "Abc@123", "9000000000", null, null);
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

}
