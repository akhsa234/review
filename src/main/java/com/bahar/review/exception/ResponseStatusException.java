package com.bahar.review.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResponseStatusException extends RuntimeException {
    public ResponseStatusException() {
        super();
    }

    public ResponseStatusException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResponseStatusException(String message) {
        super(message);
    }

    public ResponseStatusException(Throwable cause) {
        super(cause);
    }

}
