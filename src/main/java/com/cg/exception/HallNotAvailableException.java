package com.cg.exception;

public class HallNotAvailableException extends RuntimeException{

    public HallNotAvailableException() {}
	
	public HallNotAvailableException(String str) {
		super(str);
	}

}
