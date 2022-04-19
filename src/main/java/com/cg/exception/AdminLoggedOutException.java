package com.cg.exception;

public class AdminLoggedOutException extends RuntimeException{

    public AdminLoggedOutException() {}
	
	public AdminLoggedOutException(String str) {
		super(str);
	}

}
