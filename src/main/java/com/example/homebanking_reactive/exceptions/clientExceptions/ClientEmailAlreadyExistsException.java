package com.example.homebanking_reactive.exceptions.clientExceptions;

public class ClientEmailAlreadyExistsException extends RuntimeException {
    public ClientEmailAlreadyExistsException(String message) {
        super(message);
    }
}
