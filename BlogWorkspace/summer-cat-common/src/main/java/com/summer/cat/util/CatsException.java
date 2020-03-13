package com.summer.cat.util;

public class CatsException extends RuntimeException {

    public CatsException() {
        super();
    }

    public CatsException(String msg) {
        super(msg);
    }

    public CatsException(Exception e) {
        super(e);
    }
}
