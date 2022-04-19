package com.cg.exception;

public class AdminAvailableException extends RuntimeException{

    public AdminAvailableException() {}
	
	public AdminAvailableException(String str) {
		super(str);
	}

}
