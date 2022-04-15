package com.cg.service;

import java.util.List;

import java.util.Optional;
import java.util.regex.Matcher;
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
import com.cg.entity.Hall;
import com.cg.entity.Vendor;
import com.cg.exception.AdminNotFoundException;
import com.cg.exception.VendorNotFoundException;
import com.cg.repository.AdminRepository;
//import com.cg.repository.HallRepository;
import com.cg.repository.VendorRepository;

@Service
public class AdminService {
	
	//Admin repository instance
	@Autowired
	AdminRepository adminRepository;

	//Vendor repository instance
	@Autowired
	VendorRepository vendorRepository;

	Pattern namePattern = Pattern.compile("^[A-Za-z]+$");
	
	//Methods for admin
	public ResponseEntity<Object> addAdmin(Admin admin) {
		
		Matcher firstNameMatcher = namePattern.matcher(admin.getFirstName());

		Matcher lastNameMatcher = namePattern.matcher(admin.getLastName());
		
		for(char c : admin.getFirstName().toCharArray()){
			if(Character.isDigit(c))
	            return new ResponseEntity<Object>("First name should not contain digit.", HttpStatus.BAD_REQUEST);
		}
		
		for(char c : admin.getLastName().toCharArray()){
			if(Character.isDigit(c))
	            return new ResponseEntity<Object>("Last name should not contain digit.", HttpStatus.BAD_REQUEST);
		}
		
		if(!firstNameMatcher.matches())
			return new ResponseEntity<Object>("First name is not valid.", HttpStatus.BAD_REQUEST);
		
		if(!lastNameMatcher.matches())
			return new ResponseEntity<Object>("Last name is not valid.", HttpStatus.BAD_REQUEST);
		
		if(admin.getAdminContact().length() != 10)
			return new ResponseEntity<Object>("Contact number is not valid, must be of 10 digits.", HttpStatus.BAD_REQUEST);
		
		for(char c : admin.getAdminContact().toCharArray()){
			if(!Character.isDigit(c))
	            return new ResponseEntity<Object>("Contact number is not valid, must be numeric.", HttpStatus.BAD_REQUEST);
		}
		
		String pass = admin.getPassword();
		if(pass.length() < 8)
			return new ResponseEntity<Object>("Password should be minimum 8 length.", HttpStatus.BAD_REQUEST);
		
		int upperCharCount = 0;
		int lowerCharCount = 0;
		int digitCount = 0;
		int specialCharCount = 0;
		
		for(int i=0; i<pass.length(); i++) {
			
			if(Character.isUpperCase(pass.charAt(i)))
				upperCharCount++;
			
			if(Character.isLowerCase(pass.charAt(i)))
				lowerCharCount++;
			
			if(Character.isDigit(pass.charAt(i)))
				digitCount++;
			
			if(pass.charAt(i) == '!' || pass.charAt(i) == '@' || 
				pass.charAt(i) == '#' || pass.charAt(i) == '$' ||
				pass.charAt(i) == '%' || pass.charAt(i) == '*' )
				specialCharCount++;
			
		}
		
		if(upperCharCount == 0)
			return new ResponseEntity<Object>("Password must contain at least one uppercase character.", HttpStatus.BAD_REQUEST);
		
		if(lowerCharCount == 0)
			return new ResponseEntity<Object>("Password must contain at least one lowercase character.", HttpStatus.BAD_REQUEST);
		
		if(digitCount == 0)
			return new ResponseEntity<Object>("Password must contain at least one digit.", HttpStatus.BAD_REQUEST);
		
		if(specialCharCount == 0)
			return new ResponseEntity<Object>("Password must contain at least one special character from !,@,#,$,%,*.", HttpStatus.BAD_REQUEST);
		
		if(upperCharCount + lowerCharCount + digitCount + specialCharCount != pass.length())
			return new ResponseEntity<Object>("Password does not match the policy, "
					+ "it should contain at least one uppercase character, lowercase character, digit and special character.", HttpStatus.BAD_REQUEST);
		
		adminRepository.save(admin);
		
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
		
		if(admin == null) {
			
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
	
	public ResponseEntity<Object> getByAdminContact(String adminContact){
		
		Admin admin = adminRepository.findByAdminContact(adminContact);
		
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
	
	
	
	
	//Methods for Vendor
	public String addVendor(Vendor vendor) {
		
		vendorRepository.save(vendor);
		
		return "Vendor added successfully.";
	}
	
	public String removeAllVendor() {
		
		adminRepository.deleteAll();
		return "All vendor deleted successfully.";
		
	}
	
	public String removeVendorById(int id) {
		
		if(!vendorRepository.existsById(id)) {

			throw new VendorNotFoundException("Vendor not found.");
		
		}
		
		vendorRepository.deleteById(id);
		return "Vendor deleted successfully.";
	}
	
	public ResponseEntity<Object> getAllVendor() {
	
		List<Vendor> vendor = vendorRepository.findAll();
		
		if(vendor == null) {
			
			throw new VendorNotFoundException("Vendor not found.");
			
		}
		return new ResponseEntity<Object>(vendor, HttpStatus.OK);
	}
	
	public ResponseEntity<Object> getVendorByPage(int m, int n) {

		Pageable page = PageRequest.of(m, n);
		
		Page<Vendor> vendor= vendorRepository.findAll(page);

		if(vendor == null) {
			
			throw new VendorNotFoundException("Vendor not found.");
			
		}
		return new ResponseEntity<Object>(vendor, HttpStatus.OK);
	}
	
	public ResponseEntity<Object> getVendorById(int id) {

		Optional<Vendor> vendor= vendorRepository.findById(id);
		
		if(vendor == null) {
			
			throw new VendorNotFoundException("Vendor not found.");
			
		}
		return new ResponseEntity<Object>(vendor, HttpStatus.OK);
		
	}
	
	public List<ResponseEntity<Object>> getVendorByFirstName(String firstName){
		
		List<Admin> vendor = vendorRepository.findByFirstName(firstName);
		
		if(vendor == null ) {
			
			throw new VendorNotFoundException("Vendor not found.");
			
		}
		return (List<ResponseEntity<Object>>) new ResponseEntity<Object>(vendor, HttpStatus.OK);
				
	}
	
	public List<ResponseEntity<Object>> getVendorByLastName(String lastName){
		
		List<Admin> vendor = vendorRepository.findByLastName(lastName);
		
		if(vendor == null ) {
			
			throw new VendorNotFoundException("Vendor not found.");
			
		}
		return (List<ResponseEntity<Object>>) new ResponseEntity<Object>(vendor, HttpStatus.OK);
				
	}
	
	public ResponseEntity<Object> getByVendorContact(String adminContact){
		
		Vendor vendor = vendorRepository.findByVendorContact(adminContact);
		
		if(vendor == null ) {
			
			throw new VendorNotFoundException("Vendor not found.");
			
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

		List<Vendor> vendor = vendorRepository.findAll(Sort.by("firstName"));

		if(vendor == null) {
			
			throw new VendorNotFoundException("Vendor not found.");
			
		}
		return (List<ResponseEntity<Object>>) new ResponseEntity<Object>(vendor, HttpStatus.OK);
	}
	
	public List<ResponseEntity<Object>> getVendorSortedByLastName() {

		List<Vendor> vendor = vendorRepository.findAll(Sort.by("lastName"));

		if(vendor == null) {
			
			throw new VendorNotFoundException("Vendor not found.");
			
		}
		return (List<ResponseEntity<Object>>) new ResponseEntity<Object>(vendor, HttpStatus.OK);
	}
	
	
	
	
//	//Methods for hall
//	public String addHall(Hall hall) {
//		
//		hallRepository.save(hall);
//		
//		return "Hall added successfully.";
//	}
//	
//	public String removeAllHall() {
//		
//		hallRepository.deleteAll();
//		return "All hall deleted successfully.";
//	}
//	
//	public String removeHallById(int id) {
//		
//		if(hallRepository.existsById(id)) {
//			
//			hallRepository.deleteById(id);
//			return "Hall deleted successfully.";
//		
//		}
//		return "Hall not found.";
//	}
//	
//	public ResponseEntity<Object> getAllHall() {
//	
//		List<Hall> hall = hallRepository.findAll();
//		
//		if(hall == null) {
//			
//		}
//		return new ResponseEntity<Object>(hall, HttpStatus.OK);
//	}
//	
//	public ResponseEntity<Object> getHallById(int id) {
//
//		Optional<Hall> hall = hallRepository.findById(id);
//		
//		if(hall == null) {
//			
//		}
//		return new ResponseEntity<Object>(hall, HttpStatus.OK);
//		
//	}
//	
//	public ResponseEntity<Object> getHallByPage(int m, int n) {
//
//		Pageable page = PageRequest.of(m, n);
//		
//		Page<Hall> hall= hallRepository.findAll(page);
//
//		if(hall == null) {
//			
//		}
//		return new ResponseEntity<Object>(hall, HttpStatus.OK);
//	}
//	
//	public List<ResponseEntity<Object>> getHallSortedById() {
//
//		List<Hall> hall = hallRepository.findAll(Sort.by("hallId"));
//
//		if(hall == null) {
//			
//		}
//		return (List<ResponseEntity<Object>>) new ResponseEntity<Object>(hall, HttpStatus.OK);
//	}

}