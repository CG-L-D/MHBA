package com.cg.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.cg.entity.Hall;
import com.cg.entity.HallOffers;
import com.cg.entity.Vendor;

@SpringBootTest
public class HallTest {

	@Autowired
	HallController hallController;

    @Test
    final void testAddHallName(){
        Vendor vendor = new Vendor(102,"bhavya", "aggarwal", "7055573422", true, true,
			true, true, true, 40000);
        HallOffers hallOffers1 = new HallOffers(23,"Electrical", "AC",true);
        HallOffers hallOffers2 = new HallOffers(24,"Dining", "Veg",true);
        List<HallOffers> hallOffersList= new ArrayList<HallOffers>();
        hallOffersList.add(hallOffers1);
        hallOffersList.add(hallOffers2);
        assertEquals("<400 BAD_REQUEST Bad Request,Name should not contain digit.,[]>", hallController.addHall(new Hall(101, "Hall1",6, 9000, "kakadeo", "Kanpur", 500000, false,vendor,hallOffersList)).toString());
    }

	@Test
    final void testFindHallByCity(){
        hallController.removeAllHall();
    }

    // @Autowired
    // HallController hallController;
    //
    // @Test
    // final void testAddHallName(){
    // Vendor vendor = new Vendor(102,"bhavya", "aggarwal", "7055573422", true,
    // true,
    // true, true, true, 40000);
    // HallOffers hallOffers1 = new HallOffers(23,"Electrical", "AC",true);
    // HallOffers hallOffers2 = new HallOffers(24,"Dining", "Veg",true);
    // List<HallOffers> hallOffersList= new ArrayList<HallOffers>();
    // hallOffersList.add(hallOffers1);
    // hallOffersList.add(hallOffers2);
    // assertEquals("<400 BAD_REQUEST Bad Request,Name should not contain
    // digit.,[]>", hallController.addHall(new Hall(101, "Hall1",6, 9000, "kakadeo",
    // "Kanpur", 500000, false,vendor,hallOffersList)).toString());
    // }
    //
    //

    // @Test
    // final void testRemoveAllHall(){
    // asserEquals("all Hall removed successfully",hallController.removeAllHall());
    // }


}
