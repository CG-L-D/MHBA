package com.cg.exception;

public class HallNotFoundException extends RuntimeException {

    public HallNotFoundException() {
    }

    public HallNotFoundException(String str) {
        super(str);
    }

}
