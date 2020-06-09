package com.jokenpo.jokenpo.application.exception;

import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

public class PlayerNotFoundException extends ResponseStatusException {

    public PlayerNotFoundException(String message) {
        super(BAD_REQUEST, message);
    }
}
