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

		// Matcher firstNameMatcher = namePattern.matcher(admin.getFirstName());
		//
		// Matcher lastNameMatcher = namePattern.matcher(admin.getLastName());
		//
		// for(char c : admin.getFirstName().toCharArray()){
		// if(Character.isDigit(c))
		// return new ResponseEntity<Object>("First name should not contain digit.",
		// HttpStatus.BAD_REQUEST);
		// }
		//
		// for(char c : admin.getLastName().toCharArray()){
		// if(Character.isDigit(c))
		// return new ResponseEntity<Object>("Last name should not contain digit.",
		// HttpStatus.BAD_REQUEST);
		// }
		//
		// if(!firstNameMatcher.matches())
		// return new ResponseEntity<Object>("First name is not valid.",
		// HttpStatus.BAD_REQUEST);
		//
		// if(!lastNameMatcher.matches())
		// return new ResponseEntity<Object>("Last name is not valid.",
		// HttpStatus.BAD_REQUEST);

		// if(admin.getContact().length() != 10)
		// return new ResponseEntity<Object>("Contact number is not valid, must be of 10
		// digits.", HttpStatus.BAD_REQUEST);
		//
		// for(char c : admin.getContact().toCharArray()){
		// if(!Character.isDigit(c))
		// return new ResponseEntity<Object>("Contact number is not valid, must be
		// numeric.", HttpStatus.BAD_REQUEST);
		// }

		// String pass = admin.getPassword();
		// if(pass.length() < 8)
		// return new ResponseEntity<Object>("Password should be minimum 8 length.",
		// HttpStatus.BAD_REQUEST);
		//
		// int upperCharCount = 0;
		// int lowerCharCount = 0;
		// int digitCount = 0;
		// int specialCharCount = 0;
		//
		// for(int i=0; i<pass.length(); i++) {
		//
		// if(Character.isUpperCase(pass.charAt(i)))
		// upperCharCount++;
		//
		// if(Character.isLowerCase(pass.charAt(i)))
		// lowerCharCount++;
		//
		// if(Character.isDigit(pass.charAt(i)))
		// digitCount++;
		//
		// if(pass.charAt(i) == '!' || pass.charAt(i) == '@' ||
		// pass.charAt(i) == '#' || pass.charAt(i) == '$' ||
		// pass.charAt(i) == '%' || pass.charAt(i) == '*' )
		// specialCharCount++;
		//
		// }
		//
		// if(upperCharCount == 0)
		// return new ResponseEntity<Object>("Password must contain at least one
		// uppercase character.", HttpStatus.BAD_REQUEST);
		//
		// if(lowerCharCount == 0)
		// return new ResponseEntity<Object>("Password must contain at least one
		// lowercase character.", HttpStatus.BAD_REQUEST);
		//
		// if(digitCount == 0)
		// return new ResponseEntity<Object>("Password must contain at least one
		// digit.", HttpStatus.BAD_REQUEST);
		//
		// if(specialCharCount == 0)
		// return new ResponseEntity<Object>("Password must contain at least one special
		// character from !,@,#,$,%,*.", HttpStatus.BAD_REQUEST);
		//
		// if(upperCharCount + lowerCharCount + digitCount + specialCharCount !=
		// pass.length())
		// return new ResponseEntity<Object>("Password does not match the policy, "
		// + "it should contain at least one uppercase character, lowercase character,
		// digit and special character.", HttpStatus.BAD_REQUEST);
		// try {
		//
		adminRepository.save(admin);
		//
		// }
		// catch(Throwable e) {
		// if(e instanceof ConstraintViolationException) {
		// ConstraintViolationException ce = (ConstraintViolationException) e;
		// String constraintName = ce.getConstraintName();
		// }
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
			Optional<Admin> admin = adminRepository.findById(id);
			System.out.println(admin);
			if (admin.isEmpty()) {
	
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
		return (List<ResponseEntity<Object>>) new ResponseEntity<Object>(admin, HttpStatus.OK);
				
	}
	
	public ResponseEntity<Object> getByAdminContact(String adminContact){
		
		Admin admin = adminRepository.findByAdminContact(adminContact);
		
		if(admin == null ) {
			
		if(currentAdmin != null) {
			List<Admin> admin = adminRepository.findByLastName(lastName);
	
			if (admin == null) {
	
				return new ResponseEntity<Object>("Admin not found.", HttpStatus.OK);
	
			}
			return new ResponseEntity<Object>(admin, HttpStatus.OK);

		}
		return new ResponseEntity<Object>("Please sign in.", HttpStatus.OK);

	}

	public ResponseEntity<Object> getByContact(String contact) {

		if(currentAdmin != null) {
			Admin admin = adminRepository.findByContact(contact);
	
			if (admin == null) {
	
				return new ResponseEntity<Object>("Admin not found.", HttpStatus.OK);
	
			}
			return new ResponseEntity<Object>(admin, HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Please sign in.", HttpStatus.OK);

	}

	public ResponseEntity<Object> getAdminByEmail(String email) {

		Admin admin = adminRepository.findByEmail(email);

		if (admin == null) {

			return new ResponseEntity<Object>("Admin not found.", HttpStatus.OK);

		}
		return new ResponseEntity<Object>(admin, HttpStatus.OK);

	}

	public ResponseEntity<Object> getAdminSortedByFirstName() {

		List<Admin> admin = adminRepository.findAll(Sort.by("firstName"));

		Optional<Vendor> vendor= vendorRepository.findById(id);
		
		if(vendor == null) {
			
		}
		return new ResponseEntity<Object>(vendor, HttpStatus.OK);
		
	}
	
	public List<ResponseEntity<Object>> getVendorByFirstName(String firstName){
		
		List<Admin> vendor = vendorRepository.findByFirstName(firstName);
		
		if(vendor == null ) {
			
		}
		return (List<ResponseEntity<Object>>) new ResponseEntity<Object>(vendor, HttpStatus.OK);
				
	}
	
	public List<ResponseEntity<Object>> getVendorByLastName(String lastName){
		
		List<Admin> vendor = vendorRepository.findByLastName(lastName);
		
		if(vendor == null ) {
			
		}
		return (List<ResponseEntity<Object>>) new ResponseEntity<Object>(vendor, HttpStatus.OK);
				
	}
	
	public ResponseEntity<Object> getByVendorContact(String adminContact){
		
		Vendor vendor = vendorRepository.findByVendorContact(adminContact);
		
		if(vendor == null ) {
			
		}
		return new ResponseEntity<Object>(vendor, HttpStatus.OK);
				
	}
	
//	public ResponseEntity<Object> getVendorByEmail(String email){
//		
//		Vendor vendor = vendorRepository.findByEmail(email);
//		
//		if(vendor == null ) {
//			
//		}
//		return new ResponseEntity<Object>(vendor, HttpStatus.OK);
//				
//	}
	
	public List<ResponseEntity<Object>> getVendorSortedByFirstName() {

			return new ResponseEntity<Object>("Admin not found.", HttpStatus.OK);

		}
		return new ResponseEntity<Object>(admin, HttpStatus.OK);
	}

	public ResponseEntity<Object> getAdminSortedByLastName() {

		List<Admin> admin = adminRepository.findAll(Sort.by("lastName"));

		if (admin == null) {

			return new ResponseEntity<Object>("Admin not found.", HttpStatus.OK);

		}
		return new ResponseEntity<Object>(admin, HttpStatus.OK);
	}

}