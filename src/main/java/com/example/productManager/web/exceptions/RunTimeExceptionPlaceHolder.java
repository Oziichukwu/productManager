package com.example.productManager.web.exceptions;

public class RunTimeExceptionPlaceHolder extends GenException {
    public RunTimeExceptionPlaceHolder() {
    }

    public RunTimeExceptionPlaceHolder(String message) {
        super(message);
    }

    public RunTimeExceptionPlaceHolder(String message, Throwable cause) {
        super(message, cause);
    }

    public RunTimeExceptionPlaceHolder(Throwable cause) {
        super(cause);
    }
}
