package com.cg.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import com.cg.entity.Admin;
import com.cg.entity.Hall;
import com.cg.entity.Supervisor;
import com.cg.entity.Vendor;
import com.cg.repository.HallRepository;
import com.cg.service.HallService;
import com.cg.MhbaApplicationTests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

class HallServiceTest extends MhbaApplicationTests {

    @MockBean
    HallRepository hallRepository;

    @Autowired
    HallService hallService;

    @BeforeEach
    void setUp() {
        Hall hall = hall = new Hall(101, "palace", 40, 500, "civil line", "city", 70000, false, null, null);
    }

}