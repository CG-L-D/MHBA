package com.cg.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.exception.AdminNotFoundException;
import com.cg.exception.VendorNotFoundException;
import com.cg.exception.HallNotFoundException;

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

	@ExceptionHandler(value = ConstraintViolationException.class)
	protected ResponseEntity<Object> adminConstraintViolationException(ConstraintViolationException e) {

		return (ResponseEntity<Object>) (e.getConstraintViolations());

	}

	@ExceptionHandler(value = HallNotFoundException.class)
	public ResponseEntity<Object> HallNotFoundException(Exception e) {

		return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);

	}

}
