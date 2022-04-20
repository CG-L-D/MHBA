package com.cg.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.entity.Hall;
import com.cg.repository.HallRepository;
import com.cg.exception.HallNotFoundException;

//HallService
@Service
public class HallService {

	// Hall repository instance
	@Autowired
	private HallRepository hallRepository;

	static Logger log = Logger.getLogger(HallService.class.getName());

	public ResponseEntity<Object> addHall(Hall hall) {

		hallRepository.save(hall);
		log.info("Hall added");
		return new ResponseEntity<>("Hall added successfully", HttpStatus.OK);

	}

	public ResponseEntity<Object> getAllHall() {
		List<Hall> halls = hallRepository.findAll();

		if (halls.isEmpty())
			return new ResponseEntity<>(halls, HttpStatus.OK);

		throw new HallNotFoundException("No hall found.");
	}

	public ResponseEntity<Object> findHallByCity(String city) {
		List<Hall> halls = hallRepository.findByHallCity(city);

		if (halls.isEmpty())
			return new ResponseEntity<>(halls, HttpStatus.OK);

		log.error("No hall available in " + city);
		throw new HallNotFoundException("No halls available of at your city.");
	}

	public ResponseEntity<Object> findHallByLocation(String city, String location) {
		List<Hall> halls = hallRepository.findByHallCityAndHallLocation(city, location);
		if (halls.isEmpty())
			return new ResponseEntity<>(halls.get(0), HttpStatus.OK);
		log.error("No hall available in " + city + " at " + location);
		throw new HallNotFoundException("No halls available of at your city and location.");
	}

	public ResponseEntity<Object> findByCapacity(String city, int capacity) {
		List<Hall> halls = hallRepository.findByHallCityAndHallCapacity(city, capacity);
		if (halls.isEmpty())
			return new ResponseEntity<>(halls, HttpStatus.OK);
		log.error("No hall available in " + city + " for " + capacity + " people");
		throw new HallNotFoundException("No halls available of that capacity at your location");
	}

	public ResponseEntity<Object> removeHall(int id) {
		if (hallRepository.existsById(id)) {
			hallRepository.deleteById(id);
			log.info("Hall deleted with id" + id);
			return new ResponseEntity<>("Hall deleted succeccfully", HttpStatus.OK);
		}

		throw new HallNotFoundException("Hall not Found");
	}

	public void updateRevenue(int id, double bill) {

		Hall hall = hallRepository.getById(id);
		hall.setHallRevenue(hall.getHallRevenue() + bill);

		log.info("Hall with id, " + id + " updated revenue.");

	}
}
