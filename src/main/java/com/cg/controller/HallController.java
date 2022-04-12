package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Hall;
import com.cg.service.HallService;

@RestController
public class HallController {

		@Autowired
		public HallService hallService;
		
		@RequestMapping("/addHall")
		public String addHall(@RequestBody Hall hall) {
			return hallService.addHall(hall);
		}
		
		@GetMapping("/getAllHall")
		public List<Hall> getHall(){
			return hallService.getAllHall();
		}
}
