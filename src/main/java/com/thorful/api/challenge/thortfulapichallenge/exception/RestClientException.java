package com.thorful.api.challenge.thortfulapichallenge.exception;

public class RestClientException extends RuntimeException {

    private static final long serialVersionUID = -4197441461715338104L;

    public RestClientException() {
        super();
    }

    public RestClientException(String message) {
        super(message);
    }
}
