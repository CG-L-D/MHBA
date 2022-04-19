package com.cg.exception;

public class CustomerNotLoggedInException extends RuntimeException{

    public CustomerNotLoggedInException() {}
	
	public CustomerNotLoggedInException(String str) {
		super(str);
	}

}
