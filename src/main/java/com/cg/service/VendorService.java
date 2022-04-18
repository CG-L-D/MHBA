package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.entity.Customer;
import com.cg.entity.Admin;
import com.cg.entity.Vendor;
import com.cg.repository.CustomerRepository;
import com.cg.repository.HallRepository;
import com.cg.repository.VendorRepository;
import com.cg.entity.Hall;

@Service
public class VendorService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private VendorRepository vendorRepo;

	@Autowired
	private HallRepository hallRepository;

	public ResponseEntity<Object> addVendor(Vendor vendor) {
		vendorRepo.save(vendor);
		return new ResponseEntity<Object>( "Vendor Added Successfully..", HttpStatus.OK);
	}

	public ResponseEntity<Object> removeAllVendor() {

		vendorRepo.deleteAll();
		return new ResponseEntity<Object>("All vendor deleted successfully.",HttpStatus.OK);
	}

	public ResponseEntity<Object> removeVendorById(int id) {

		if (vendorRepo.existsById(id)) {

			vendorRepo.deleteById(id);
			return new ResponseEntity<Object>( "Vendor deleted successfully", HttpStatus.OK);
		}
		return new ResponseEntity<Object>( "Vendor not found", HttpStatus.OK);
	}

	public ResponseEntity<Object> getAllVendor() {

		List<Vendor> vendor = vendorRepo.findAll();

		if (vendor == null) {
			return new ResponseEntity<Object>("Vendor not found.", HttpStatus.OK);

		}
		return new ResponseEntity<Object>(vendor, HttpStatus.OK);
	}

	public ResponseEntity<Object> getVendorByPage(int m, int n) {

		Pageable page = PageRequest.of(m, n);

		Page<Vendor> vendor = vendorRepo.findAll(page);

		if (vendor == null) {

			return new ResponseEntity<Object>("Vendor not found.", HttpStatus.OK);

		}
		return new ResponseEntity<Object>(vendor, HttpStatus.OK);
	}

	public ResponseEntity<Object> getVendorById(int id) {

		Optional<Vendor> vendor = vendorRepo.findById(id);

		if (vendor == null) {

			return new ResponseEntity<Object>("Vendor not found.", HttpStatus.OK);

		}
		return new ResponseEntity<Object>(vendor, HttpStatus.OK);

	}

	public ResponseEntity<Object> getVendorByFirstName(String firstName) {

		List<Admin> vendor = vendorRepo.findByVendorFirstName(firstName);

		if (vendor == null) {

			return new ResponseEntity<Object>("Vendor not found.", HttpStatus.OK);

		}
		return new ResponseEntity<Object>(vendor, HttpStatus.OK);

	}

	public ResponseEntity<Object> getVendorByLastName(String lastName) {

		List<Admin> vendor = vendorRepo.findByVendorLastName(lastName);

		if (vendor == null) {

			return new ResponseEntity<Object>("Vendor not found.", HttpStatus.OK);

		}
		return new ResponseEntity<Object>(vendor, HttpStatus.OK);

	}

	public ResponseEntity<Object> getByVendorContact(String adminContact) {

		Vendor vendor = vendorRepo.findByVendorContact(adminContact);

		if (vendor == null) {

			return new ResponseEntity<Object>("Vendor not found.", HttpStatus.OK);

		}
		return new ResponseEntity<Object>(vendor, HttpStatus.OK);

	}

	public boolean bookVendor(int hallId, boolean flower, boolean catering, boolean music, boolean video) {

		List<Vendor> vendors = vendorRepo.findByServices(flower, catering, music, video);

		if (vendors != null) {
			for (Vendor v : vendors) {
				if (v.getIsVendorAvailable()) {

					v.setIsVendorAvailable(false);
					Hall h = hallRepository.findById(hallId).get();
					if (h != null)
						h.setVendor(v);

					return true;
				}

			}
			return false;
		}
		return false;
	}

}
