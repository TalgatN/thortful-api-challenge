package com.thorful.api.challenge.thortfulapichallenge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Not found")
public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = -7065689454237515507L;

    public NotFoundException(String message) {
        super(message);
    }
}