package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.entity.Hall;
import com.cg.repository.HallRepository;

@Service
public class HallService {

	@Autowired
	private HallRepository hallRepository;

	public String addHall(Hall hall) {

		hallRepository.save(hall);
		return "hall added successfully";
	}

	public ResponseEntity<Object> getAllHall() {
		List<Hall> halls = hallRepository.findAll();

		if (halls != null)
			return new ResponseEntity<Object>(halls, HttpStatus.OK);
		return new ResponseEntity<Object>("No halls available.", HttpStatus.OK);
	}

	public ResponseEntity<Object> findHallByCity(String city) {
		List<Hall> halls = hallRepository.findByCity(city);

		if (halls != null)
			return new ResponseEntity<Object>(halls, HttpStatus.OK);
		return new ResponseEntity<Object>("No halls available of at your city.", HttpStatus.OK);
	}

	public ResponseEntity<Object> findHallByLocation(String city, String location) {
		List<Hall> halls = hallRepository.findByCityAndLocation(city, location);
		if (halls != null)
			return new ResponseEntity<Object>(halls.get(0), HttpStatus.OK);
		return new ResponseEntity<Object>("No halls available at your location.", HttpStatus.OK);
	}

	public ResponseEntity<Object> findByCapacity(String city, int capacity) {
		List<Hall> halls = hallRepository.findByCityAndCapacity(city, capacity);

		if (halls != null)
			return new ResponseEntity<Object>(halls, HttpStatus.OK);
		return new ResponseEntity<Object>("No halls available of that capacity at your location", HttpStatus.OK);
	}

}
