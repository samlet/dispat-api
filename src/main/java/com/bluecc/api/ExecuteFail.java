package com.bluecc.api;

public class ExecuteFail extends RuntimeException{
    public ExecuteFail(String message, Throwable cause) {
        super(message, cause);
    }
}
