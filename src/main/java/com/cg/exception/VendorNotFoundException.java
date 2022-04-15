package com.cg.exception;

public class VendorNotFoundException extends RuntimeException {
	
	public VendorNotFoundException() {}
	
	public VendorNotFoundException(String str) {
		super(str);
	}

}
