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

import com.cg.entity.Admin;
import com.cg.entity.Hall;
import com.cg.entity.Vendor;
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

//	//Hall repository instance
//	@Autowired
//	HallRepository hallRepository;
//	
	
	//Methods for admin
	public String addAdmin(Admin admin) {
		
		adminRepository.save(admin);
		
		return "Admin added successfully.";
	}
	
	public String removeAllAdmin() {
		
		adminRepository.deleteAll();
		return "All admin deleted successfully.";
	}
	
	public String removeAdminById(int id) {
		
		if(adminRepository.existsById(id)) {
			
			adminRepository.deleteById(id);
			return "Admin deleted successfully.";
		
		}
		return "Admin not found.";
	}
	
	public ResponseEntity<Object> getAllAdmin() {
	
		List<Admin> admin = adminRepository.findAll();
		
		if(admin == null) {
			
		}
		return new ResponseEntity<Object>(admin, HttpStatus.OK);
	}
	
	public ResponseEntity<Object> getAdminByPage(int m, int n) {

		Pageable page = PageRequest.of(m, n);
		
		Page<Admin> admin= adminRepository.findAll(page);

		if(admin == null) {
			
		}
		return new ResponseEntity<Object>(admin, HttpStatus.OK);
	}
	
	public ResponseEntity<Object> getAdminById(int id) {

		Optional<Admin> admin = adminRepository.findById(id);
		
		if(admin == null) {
			
		}
		return new ResponseEntity<Object>(admin, HttpStatus.OK);
		
	}
	
	public List<ResponseEntity<Object>> getAdminByFirstName(String firstName){
		
		List<Admin> admin = adminRepository.findByFirstName(firstName);
		
		if(admin == null ) {
			
		}
		return (List<ResponseEntity<Object>>) new ResponseEntity<Object>(admin, HttpStatus.OK);
				
	}
	
	public List<ResponseEntity<Object>> getAdminByLastName(String lastName){
		
		List<Admin> admin = adminRepository.findByLastName(lastName);
		
		if(admin == null ) {
			
		}
		return (List<ResponseEntity<Object>>) new ResponseEntity<Object>(admin, HttpStatus.OK);
				
	}
	
	public ResponseEntity<Object> getByAdminContact(String adminContact){
		
		Admin admin = adminRepository.findByAdminContact(adminContact);
		
		if(admin == null ) {
			
		}
		return new ResponseEntity<Object>(admin, HttpStatus.OK);
				
	}
	
	public ResponseEntity<Object> getAdminByEmail(String email){
		
		Admin admin = adminRepository.findByEmail(email);
		
		if(admin == null ) {
			
		}
		return new ResponseEntity<Object>(admin, HttpStatus.OK);
				
	}
	
	public List<ResponseEntity<Object>> getAdminSortedByFirstName() {

		List<Admin> admin = adminRepository.findAll(Sort.by("firstName"));

		if(admin == null) {
			
		}
		return (List<ResponseEntity<Object>>) new ResponseEntity<Object>(admin, HttpStatus.OK);
	}
	
	public List<ResponseEntity<Object>> getAdminSortedByLastName() {

		List<Admin> admin = adminRepository.findAll(Sort.by("lastName"));

		if(admin == null) {
			
		}
		return (List<ResponseEntity<Object>>) new ResponseEntity<Object>(admin, HttpStatus.OK);
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
		
		if(vendorRepository.existsById(id)) {
			
			vendorRepository.deleteById(id);
			return "Vendor deleted successfully.";
		
		}
		return "Vendor not found.";
	}
	
	public ResponseEntity<Object> getAllVendor() {
	
		List<Vendor> vendor = vendorRepository.findAll();
		
		if(vendor == null) {
			
		}
		return new ResponseEntity<Object>(vendor, HttpStatus.OK);
	}
	
	public ResponseEntity<Object> getVendorByPage(int m, int n) {

		Pageable page = PageRequest.of(m, n);
		
		Page<Vendor> vendor= vendorRepository.findAll(page);

		if(vendor == null) {
			
		}
		return new ResponseEntity<Object>(vendor, HttpStatus.OK);
	}
	
	public ResponseEntity<Object> getVendorById(int id) {

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

		List<Vendor> vendor = vendorRepository.findAll(Sort.by("firstName"));

		if(vendor == null) {
			
		}
		return (List<ResponseEntity<Object>>) new ResponseEntity<Object>(vendor, HttpStatus.OK);
	}
	
	public List<ResponseEntity<Object>> getVendorSortedByLastName() {

		List<Vendor> vendor = vendorRepository.findAll(Sort.by("lastName"));

		if(vendor == null) {
			
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