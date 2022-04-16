package com.cg.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ConstraintViolationException extends RuntimeException {

	public ConstraintViolationException() {}
	
	public ConstraintViolationException(String str) {
		super(str);
	}
}
