package com.cg.exception;

public class HallNotFoundException extends RuntimeException {

    public HallNotFoundException() {
        super("Hall not found");
    }

    public HallNotFoundException(String str) {
        super(str);
    }

}
