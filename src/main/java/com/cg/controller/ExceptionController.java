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

import com.cg.exception.AdminAvailableException;
import com.cg.exception.AdminLoggedInException;
import com.cg.exception.AdminLoggedOutException;
import com.cg.exception.AdminNotFoundException;
import com.cg.exception.CustomerNotFoundException;
import com.cg.exception.CustomerNotLoggedInException;
import com.cg.exception.HallNotAvailableException;
import com.cg.exception.VendorNotFoundException;
import com.cg.exception.HallNotFoundException;
import com.cg.exception.InvalidCredentialsException;
import com.cg.exception.SupervisorNotFoundException;


@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(value = AdminLoggedInException.class)
	public ResponseEntity<Object> alreadyLoggedInException(Exception e) {

		return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);

	}
	
	@ExceptionHandler(value = InvalidCredentialsException.class)
	public ResponseEntity<Object> invalidCredentialsException(Exception e) {

		return new ResponseEntity<Object>(e.getMessage(), HttpStatus.FORBIDDEN);

	}

	@ExceptionHandler(value = AdminLoggedOutException.class)
	public ResponseEntity<Object> alreadyLoggedOutException(Exception e) {

		return new ResponseEntity<Object>(e.getMessage(), HttpStatus.FORBIDDEN);

	}

	@ExceptionHandler(value = AdminAvailableException.class)
	public ResponseEntity<Object> adminAlreadyAvailableException(Exception e) {

		return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(value = AdminNotFoundException.class)
	public ResponseEntity<Object> adminNotFoundException(Exception e) {

		return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(value = SupervisorNotFoundException.class)
	public ResponseEntity<Object> supervisorNotFoundException(Exception e) {

		return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(value = VendorNotFoundException.class)
	public ResponseEntity<Object> vendorNotFoundException(Exception e) {

		return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(value = CustomerNotFoundException.class)
	public ResponseEntity<Object> customerNotFoundException(Exception e) {

		return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(value = CustomerNotLoggedInException.class)
	public ResponseEntity<Object> customerNotLoggedInException(Exception e){
		return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = HallNotFoundException.class)
	public ResponseEntity<Object> hallNotFoundException(Exception e) {

		return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);

	}
	
	@
	ExceptionHandler(value = HallNotAvailableException.class)
	public ResponseEntity<Object> hallNotAvailableException(Exception e) {
		return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
}
