package com.cg.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.entity.Vendor;

import com.cg.entity.Hall;
import com.cg.entity.Supervisor;
import com.cg.repository.HallRepository;
import com.cg.repository.SupervisorRepository;
import com.cg.repository.VendorRepository;

@Service
public class SupervisorService {

	@Autowired
	private VendorRepository vendorRepository;

	@Autowired
	private SupervisorRepository supervisorRepository;

	@Autowired
	private HallRepository hallRepository;

	public ResponseEntity<Object> addHall(int id, Hall hall) {
		supervisorRepository.getById(id).setHall(hall);
		return new ResponseEntity<Object>("Hall added successfully.", HttpStatus.OK);
	}

	public ResponseEntity<Object> removeHall(int id) {
		supervisorRepository.deleteById(id);
		;
		return new ResponseEntity<Object>("Hall deleted successfully.", HttpStatus.OK);
	}

	public ResponseEntity<Object> getSupervisorHallDetails(int id) {

		Supervisor supervisor = supervisorRepository.getById(id);

		if (supervisor == null) {

			return new ResponseEntity<Object>("Currently, no hall is assigned to supervisor.", HttpStatus.OK);

		}
		return new ResponseEntity<Object>(supervisor.getHall(), HttpStatus.OK);

	}

	public double generateBill(int hallId, boolean flower, boolean catering, boolean music, boolean video) {

		double billAmount = 0.0;

		Hall hall = hallRepository.getById(hallId);

		billAmount += hall.getHallPrice();

		List<Vendor> vendors = vendorRepository.findByServices(flower, catering, music, video);

		billAmount += vendors.get(0).getVendorCost();

		billAmount *= 1.18;

		return billAmount;

	}
}
