package com.cg.exception;

public class SupervisorNotFoundException extends RuntimeException {

	public SupervisorNotFoundException() {
		super("Supervisor not found");
	}

	public SupervisorNotFoundException(String str) {
		super(str);
	}

}
