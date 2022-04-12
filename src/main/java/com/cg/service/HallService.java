package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Hall;
import com.cg.repository.HallRepository;

@Service
public class HallService {

	@Autowired
	private HallRepository hallRepo;
	
	public String addHall(Hall hall) {
		hallRepo.save(hall);
		return "hall added successfully"; 
	}
	
	public List<Hall> getAllHall(){
		return hallRepo.findAll();
	}
}
