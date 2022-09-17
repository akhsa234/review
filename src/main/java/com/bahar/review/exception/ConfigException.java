package com.bahar.review.exception;

public class ConfigException extends Throwable{


    private static final long serialVersionUID = 1L;

    private String message;

    public ConfigException() {
    }

    public ConfigException(String msg) {
        setMessage(msg);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
