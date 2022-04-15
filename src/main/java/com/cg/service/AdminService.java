package com.cg.service;

import java.util.List;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import com.cg.entity.Admin;
import com.cg.repository.AdminRepository;

@Service
public class AdminService {
	
	//Admin repository instance
	@Autowired
	AdminRepository adminRepository;

	Pattern namePattern = Pattern.compile("^[A-Za-z]+$");
	
	//Methods for admin
	public ResponseEntity<Object> addAdmin(Admin admin) {
		
//		Matcher firstNameMatcher = namePattern.matcher(admin.getFirstName());
//
//		Matcher lastNameMatcher = namePattern.matcher(admin.getLastName());
//		
//		for(char c : admin.getFirstName().toCharArray()){
//			if(Character.isDigit(c))
//	            return new ResponseEntity<Object>("First name should not contain digit.", HttpStatus.BAD_REQUEST);
//		}
//		
//		for(char c : admin.getLastName().toCharArray()){
//			if(Character.isDigit(c))
//	            return new ResponseEntity<Object>("Last name should not contain digit.", HttpStatus.BAD_REQUEST);
//		}
//		
//		if(!firstNameMatcher.matches())
//			return new ResponseEntity<Object>("First name is not valid.", HttpStatus.BAD_REQUEST);
//		
//		if(!lastNameMatcher.matches())
//			return new ResponseEntity<Object>("Last name is not valid.", HttpStatus.BAD_REQUEST);
		
//		if(admin.getContact().length() != 10)
//			return new ResponseEntity<Object>("Contact number is not valid, must be of 10 digits.", HttpStatus.BAD_REQUEST);
//		
//		for(char c : admin.getContact().toCharArray()){
//			if(!Character.isDigit(c))
//	            return new ResponseEntity<Object>("Contact number is not valid, must be numeric.", HttpStatus.BAD_REQUEST);
//		}
		
//		String pass = admin.getPassword();
//		if(pass.length() < 8)
//			return new ResponseEntity<Object>("Password should be minimum 8 length.", HttpStatus.BAD_REQUEST);
//		
//		int upperCharCount = 0;
//		int lowerCharCount = 0;
//		int digitCount = 0;
//		int specialCharCount = 0;
//		
//		for(int i=0; i<pass.length(); i++) {
//			
//			if(Character.isUpperCase(pass.charAt(i)))
//				upperCharCount++;
//			
//			if(Character.isLowerCase(pass.charAt(i)))
//				lowerCharCount++;
//			
//			if(Character.isDigit(pass.charAt(i)))
//				digitCount++;
//			
//			if(pass.charAt(i) == '!' || pass.charAt(i) == '@' || 
//				pass.charAt(i) == '#' || pass.charAt(i) == '$' ||
//				pass.charAt(i) == '%' || pass.charAt(i) == '*' )
//				specialCharCount++;
//			
//		}
//		
//		if(upperCharCount == 0)
//			return new ResponseEntity<Object>("Password must contain at least one uppercase character.", HttpStatus.BAD_REQUEST);
//		
//		if(lowerCharCount == 0)
//			return new ResponseEntity<Object>("Password must contain at least one lowercase character.", HttpStatus.BAD_REQUEST);
//		
//		if(digitCount == 0)
//			return new ResponseEntity<Object>("Password must contain at least one digit.", HttpStatus.BAD_REQUEST);
//		
//		if(specialCharCount == 0)
//			return new ResponseEntity<Object>("Password must contain at least one special character from !,@,#,$,%,*.", HttpStatus.BAD_REQUEST);
//		
//		if(upperCharCount + lowerCharCount + digitCount + specialCharCount != pass.length())
//			return new ResponseEntity<Object>("Password does not match the policy, "
//					+ "it should contain at least one uppercase character, lowercase character, digit and special character.", HttpStatus.BAD_REQUEST);
		try {
			
			adminRepository.save(admin);

		}
		catch (TransactionSystemException e) {

			return new ResponseEntity<Object>("Error: " + e.getMostSpecificCause(), HttpStatus.OK);

		}
		return new ResponseEntity<Object>("Admin added successfully.", HttpStatus.OK);
	}
	
	public String removeAllAdmin() {
		
		if(adminRepository.count() != 0) {
		
			adminRepository.deleteAll();
			return "All admin deleted successfully.";
		
		}
		return "Admin not found.";
	}
	
	public String removeAdminByAdminId(int id) {
		
		if(adminRepository.existsById(id)) {
			
			adminRepository.deleteById(id);
			return "Admin deleted successfully.";
		
		}
		return "Admin not found.";
		
	}
	
	public ResponseEntity<Object> getAllAdmin() {
	
		List<Admin> admin = adminRepository.findAll();
		
		if(admin.isEmpty()) {
			
			return new ResponseEntity<Object>("Admin not found.", HttpStatus.OK);
		
		}
		return new ResponseEntity<Object>(admin, HttpStatus.OK);
	}
	
	public ResponseEntity<Object> getAdminByPage(int m, int n) {

		Pageable page = PageRequest.of(m, n);
		
		Page<Admin> admin= adminRepository.findAll(page);

		if(admin == null) {
			
			return new ResponseEntity<Object>("Admin not found.", HttpStatus.OK);
			
		}
		return new ResponseEntity<Object>(admin, HttpStatus.OK);
	}
	
	public ResponseEntity<Object> getAdminByAdminId(int id) {

		Optional<Admin> admin = adminRepository.findById(id);
		System.out.println(admin);
		if(admin.isEmpty()) {
			
			return new ResponseEntity<Object>("Admin not found.", HttpStatus.OK);
			
		}
		return new ResponseEntity<Object>(admin, HttpStatus.OK);
		
	}
	
	public ResponseEntity<Object> getAdminByFirstName(String firstName){
		
		List<Admin> admin = adminRepository.findByFirstName(firstName);
		
		if(admin == null ) {
			
			return new ResponseEntity<Object>("Admin not found.", HttpStatus.OK);
			
		}
		return new ResponseEntity<Object>(admin, HttpStatus.OK);
				
	}
	
	public ResponseEntity<Object> getAdminByLastName(String lastName){
		
		List<Admin> admin = adminRepository.findByLastName(lastName);
		
		if(admin == null ) {
			
			return new ResponseEntity<Object>("Admin not found.", HttpStatus.OK);
			
		}
		return new ResponseEntity<Object>(admin, HttpStatus.OK);
				
	}
	
	public ResponseEntity<Object> getByContact(String contact){
		
		Admin admin = adminRepository.findByContact(contact);
		
		if(admin == null ) {

			return new ResponseEntity<Object>("Admin not found.", HttpStatus.OK);

		}
		return new ResponseEntity<Object>(admin, HttpStatus.OK);
				
	}
	
	public ResponseEntity<Object> getAdminByEmail(String email){
		
		Admin admin = adminRepository.findByEmail(email);
		
		if(admin == null ) {
			
			return new ResponseEntity<Object>("Admin not found.", HttpStatus.OK);
			
		}
		return new ResponseEntity<Object>(admin, HttpStatus.OK);
				
	}
	
	public ResponseEntity<Object> getAdminSortedByFirstName() {

		List<Admin> admin = adminRepository.findAll(Sort.by("firstName"));

		if(admin == null) {
			
			return new ResponseEntity<Object>("Admin not found.", HttpStatus.OK);
			
		}
		return new ResponseEntity<Object>(admin, HttpStatus.OK);
	}
	
	public ResponseEntity<Object> getAdminSortedByLastName() {

		List<Admin> admin = adminRepository.findAll(Sort.by("lastName"));

		if(admin == null) {
			
			return new ResponseEntity<Object>("Admin not found.", HttpStatus.OK);
			
		}
		return new ResponseEntity<Object>(admin, HttpStatus.OK);
	}
	
}