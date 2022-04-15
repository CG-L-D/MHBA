package com.cg.exception;

public class AdminNotFoundException extends RuntimeException{

	public AdminNotFoundException() {}
	
	public AdminNotFoundException(String str) {
		super(str);
	}
	
}
