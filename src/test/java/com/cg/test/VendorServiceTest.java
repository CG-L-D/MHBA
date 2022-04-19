package com.cg.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import com.cg.entity.Vendor;
import com.cg.repository.VendorRepository;
import com.cg.MhbaApplicationTests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.cg.service.VendorService;

class VendorServiceTest extends MhbaApplicationTests {

    @MockBean
    VendorRepository vendorRepository;

    @Autowired
    VendorService vendorService;

    Vendor vendor;

    @BeforeEach
    void setUp() {
        vendor = new Vendor(101, "Bhavya", "Aggarwal", "9999999999", true, true, true, true, true);

    }

    @Test
    final void testBookVendor() {

    }

}