package com.cg.service;

import java.util.List;

import java.util.Optional;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.cg.entity.Admin;
import com.cg.repository.AdminRepository;

@Service
public class AdminService {

	// Admin repository instance
	@Autowired
	AdminRepository adminRepository;
	
	Admin currentAdmin = null;

	
	public ResponseEntity<Object> loginAdmin(String email, String password){
		
		if((currentAdmin = adminRepository.findByEmailAndPassword(email, password)) != null){
			return new ResponseEntity<Object>("Admin login successfull.", HttpStatus.OK);
		}
		
		return new ResponseEntity<Object>("Admin login failed, invalid credentials.", HttpStatus.FORBIDDEN);
	}
	
	public ResponseEntity<Object> logoutAdmin(){
		
		if(currentAdmin != null){
			currentAdmin = null;
			return new ResponseEntity<Object>("Admin logout successfull.", HttpStatus.OK);
		}
		
		return new ResponseEntity<Object>("Error, currently no admin logged-in.", HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<Object> addAdmin(Admin admin) {

		adminRepository.save(admin);
		return new ResponseEntity<Object>("Admin added successfully.", HttpStatus.OK);
	
	}

	public ResponseEntity<Object> removeAllAdmin() {

		if(currentAdmin != null) {
			if (adminRepository.count() != 0) {
		
				adminRepository.deleteAll();
				return new ResponseEntity<Object>("All admin deleted successfully.", HttpStatus.OK);
		
			}
			return new ResponseEntity<Object>("Admin not found.", HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Please sign in.", HttpStatus.OK);
		
	}

	public ResponseEntity<Object> removeAdminByAdminId(int id) {

		if(currentAdmin != null) {
			if (adminRepository.existsById(id)) {

				adminRepository.deleteById(id);
				return new ResponseEntity<Object>("Admin deleted successfully.", HttpStatus.OK);
				
			}
			return new ResponseEntity<Object>("Admin not found.", HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Please sign in.", HttpStatus.OK);
		
	}

	public ResponseEntity<Object> getAllAdmin() {

		if(currentAdmin != null) {
			List<Admin> admin = adminRepository.findAll();
	
			if (admin.isEmpty()) {
	
				return new ResponseEntity<Object>("Admin not found.", HttpStatus.OK);
	
			}
			return new ResponseEntity<Object>(admin, HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Please sign in.", HttpStatus.OK);
			
	}

	public ResponseEntity<Object> getAdminByPage(int m, int n) {

		if(currentAdmin != null) {
			Pageable page = PageRequest.of(m, n);
	
			Page<Admin> admin = adminRepository.findAll(page);
	
			if (admin == null) {
	
				return new ResponseEntity<Object>("Admin not found.", HttpStatus.OK);
	
			}
			return new ResponseEntity<Object>(admin, HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Please sign in.", HttpStatus.OK);
			
	}

	public ResponseEntity<Object> getAdminByAdminId(int id) {

		if(currentAdmin != null) {
			
			Admin admin = adminRepository.findById(id).get();
			System.out.println(admin);
			if (admin == null) {
	
				return new ResponseEntity<Object>("Admin not found.", HttpStatus.OK);
	
			}
			return new ResponseEntity<Object>(admin, HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Please sign in.", HttpStatus.OK);

	}

	public ResponseEntity<Object> getAdminByFirstName(String firstName) {

		if(currentAdmin != null) {
			
			List<Admin> admin = adminRepository.findByFirstName(firstName);
	
			if (admin == null) {
	
				return new ResponseEntity<Object>("Admin not found.", HttpStatus.OK);
	
			}
			return new ResponseEntity<Object>(admin, HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Please sign in.", HttpStatus.OK);

	}

	public ResponseEntity<Object> getAdminByLastName(String lastName) {


		List<Admin> admin = adminRepository.findByLastName(lastName);
		
		if(admin == null ) {
			
		}
		return new ResponseEntity<Object>(admin, HttpStatus.OK);
				
	}
	
	public ResponseEntity<Object> getByAdminContact(String adminContact){
			
		if(currentAdmin != null) {
			
			Admin admin = adminRepository.findByAdminContact(adminContact);
	
			if (admin == null) {
	
				return new ResponseEntity<Object>("Admin not found.", HttpStatus.OK);
	
			}
			return new ResponseEntity<Object>(admin, HttpStatus.OK);

		}
		return new ResponseEntity<Object>("Please sign in.", HttpStatus.OK);

	}

	public ResponseEntity<Object> getByContact(String contact) {

		if(currentAdmin != null) {
			
			Admin admin = adminRepository.findByAdminContact(contact);
	
			if (admin == null) {
	
				return new ResponseEntity<Object>("Admin not found.", HttpStatus.OK);
	
			}
			return new ResponseEntity<Object>(admin, HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Please sign in.", HttpStatus.OK);

	}

	public ResponseEntity<Object> getAdminByEmail(String email) {

		if(currentAdmin != null) {
			
			Admin admin = adminRepository.findByEmail(email);
	
			if (admin == null) {
	
				return new ResponseEntity<Object>("Admin not found.", HttpStatus.OK);
	
			}
			return new ResponseEntity<Object>(admin, HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Please sign in.", HttpStatus.OK);

	}

	public ResponseEntity<Object> getAdminSortedByFirstName() {

		if(currentAdmin != null) {
			
			List<Admin> admin = adminRepository.findAll(Sort.by("firstName"));
	
			if (admin == null) {
	
				return new ResponseEntity<Object>("Admin not found.", HttpStatus.OK);
	
			}
			return new ResponseEntity<Object>(admin, HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Please sign in.", HttpStatus.OK);
	
	}

	public ResponseEntity<Object> getAdminSortedByLastName() {

		if(currentAdmin != null) {
			
			List<Admin> admin = adminRepository.findAll(Sort.by("lastName"));
	
			if (admin == null) {
	
				return new ResponseEntity<Object>("Admin not found.", HttpStatus.OK);
	
			}
			return new ResponseEntity<Object>(admin, HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Please sign in.", HttpStatus.OK);	
	}
	
}