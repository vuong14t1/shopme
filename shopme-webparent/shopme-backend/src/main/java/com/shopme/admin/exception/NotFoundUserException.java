package com.shopme.admin.exception;

public class NotFoundUserException extends RuntimeException{
    private String message;
    public NotFoundUserException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
