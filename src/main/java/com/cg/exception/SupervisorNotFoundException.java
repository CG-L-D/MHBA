package com.cg.exception;

public class SupervisorNotFoundException extends RuntimeException{
	
	public SupervisorNotFoundException() {	}
	
	public SupervisorNotFoundException(String str){
		super(str);
	}
}
