package com.example.homebanking_reactive.exceptions;

public class ClientEmailAlreadyExistsException extends RuntimeException {
    public ClientEmailAlreadyExistsException(String message) {
        super(message);
    }
}