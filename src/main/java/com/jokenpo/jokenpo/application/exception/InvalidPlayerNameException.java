package com.jokenpo.jokenpo.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InvalidPlayerNameException extends ResponseStatusException {

    public InvalidPlayerNameException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }

}
