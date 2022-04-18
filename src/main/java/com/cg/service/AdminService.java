package com.cg.service;

import java.util.List;

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
		
		if((currentAdmin = adminRepository.findByAdminEmailAndAdminPassword(email, password)) != null){
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

	public ResponseEntity<Object> removeByAdminId(int id) {

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

	public ResponseEntity<Object> getByAdminPage(int m, int n) {

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

	public ResponseEntity<Object> getByAdminId(int id) {

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

	public ResponseEntity<Object> getByAdminFirstName(String adminFirstName) {

		if(currentAdmin != null) {
			
			List<Admin> admin = adminRepository.findByAdminFirstName(adminFirstName);
	
			if (admin == null) {
	
				return new ResponseEntity<Object>("Admin not found.", HttpStatus.OK);
	
			}
			return new ResponseEntity<Object>(admin, HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Please sign in.", HttpStatus.OK);

	}

	public ResponseEntity<Object> getByAdminLastName(String adminLastName) {


		List<Admin> admin = adminRepository.findByAdminLastName(adminLastName);
		
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

	public ResponseEntity<Object> getByAdminEmail(String email) {

		if(currentAdmin != null) {
			
			Admin admin = adminRepository.findByAdminEmail(email);
	
			if (admin == null) {
	
				return new ResponseEntity<Object>("Admin not found.", HttpStatus.OK);
	
			}
			return new ResponseEntity<Object>(admin, HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Please sign in.", HttpStatus.OK);

	}

	public ResponseEntity<Object> getSortedByAdminFirstName() {

		if(currentAdmin != null) {
			
			List<Admin> admin = adminRepository.findAll(Sort.by("adminFirstName"));
	
			if (admin == null) {
	
				return new ResponseEntity<Object>("Admin not found.", HttpStatus.OK);
	
			}
			return new ResponseEntity<Object>(admin, HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Please sign in.", HttpStatus.OK);
	
	}

	public ResponseEntity<Object> getSortedByAdminLastName() {

		if(currentAdmin != null) {
			
			List<Admin> admin = adminRepository.findAll(Sort.by("adminLastName"));
	
			if (admin == null) {
	
				return new ResponseEntity<Object>("Admin not found.", HttpStatus.OK);
	
			}
			return new ResponseEntity<Object>(admin, HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Please sign in.", HttpStatus.OK);	
	}
	
}