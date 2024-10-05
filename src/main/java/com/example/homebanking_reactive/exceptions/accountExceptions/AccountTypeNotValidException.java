package com.example.homebanking_reactive.exceptions.accountExceptions;

public class AccountTypeNotValidException extends RuntimeException {
    public AccountTypeNotValidException(String message) {
        super(message);
    }
}
