package com.cg.exception;

public class CustomerNotFoundException extends RuntimeException{

    public CustomerNotFoundException() {}
	
	public CustomerNotFoundException(String str) {
		super(str);
	}
}
