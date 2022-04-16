package com.cg.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.controller.CustomerController;
import com.cg.entity.Customer;

@SpringBootTest
class CustomerControllerTest {

	@Autowired 
	private CustomerController customerController = new CustomerController();

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddCustomer() {
		//assertEquals("Customer added successfully",customerController.addCustomer(new Customer(1,"Kaustubh","90909090","kaustubhchillure27@gmail.com")));
	}

}
