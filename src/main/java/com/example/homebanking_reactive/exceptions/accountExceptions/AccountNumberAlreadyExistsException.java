package com.example.homebanking_reactive.exceptions.accountExceptions;

public class AccountNumberAlreadyExistsException extends RuntimeException {
    public AccountNumberAlreadyExistsException(String message) {
        super(message);
    }
}
