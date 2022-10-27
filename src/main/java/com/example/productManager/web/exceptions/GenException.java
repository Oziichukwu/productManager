package com.example.productManager.web.exceptions;

public class GenException extends Throwable{

    public GenException() {
    }

    public GenException(String message) {
        super(message);
    }

    public GenException(String message, Throwable cause) {
        super(message, cause);
    }

    public GenException(Throwable cause) {
        super(cause);
    }

}
