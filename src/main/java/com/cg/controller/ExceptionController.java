package com.cg.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.exception.AdminNotFoundException;
import com.cg.exception.VendorNotFoundException;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(value = AdminNotFoundException.class)
	public ResponseEntity<Object> adminNotFoundException(Exception e) {
		
		return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
	
	}
	
	@ExceptionHandler(value = VendorNotFoundException.class)
	public ResponseEntity<Object> vendorNotFoundException(Exception e) {
		
		return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
	
	}
}
