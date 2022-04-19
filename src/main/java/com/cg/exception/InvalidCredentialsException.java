package com.cg.exception;

public class InvalidCredentialsException extends RuntimeException {

    public InvalidCredentialsException() {}
	
	public InvalidCredentialsException(String str) {
		super(str);
	}
}
