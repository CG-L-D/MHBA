package com.cg.exception;

public class AdminLoggedInException extends RuntimeException{

    public AdminLoggedInException() {}
	
	public AdminLoggedInException(String str) {
		super(str);
	}

}
