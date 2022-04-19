package com.cg.service;

import java.util.Date;
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
	private VendorRepository vendorRepo;

	@Autowired
	private HallRepository hallRepository;

	public boolean bookVendor(int hallId, Date from, Date to, boolean flower, boolean catering, boolean music,
			boolean video) {

		List<Vendor> vendors = vendorRepo.findByServices(flower, catering, music, video);

		if (vendors != null) {
			for (Vendor v : vendors) {

				Hall h = hallRepository.findById(hallId).get();

				if (v.getIsVendorAvailable() || v.getBookVendorFrom().after(to) || v.getBookVendorTo().before(from)) {

					v.setIsVendorAvailable(false);

					h.getVendors().add(v);
					hallRepository.save(h);

					v.setBookVendorFrom(from);
					v.setBookVendorTo(to);
					v.setHall(h);

					vendorRepo.save(v);

					return true;

				}

			}
			return false;
		}
		return false;
	}

}
