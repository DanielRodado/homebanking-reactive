package com.example.homebanking_reactive.exceptions.loanExceptions;

public class LoanNotFoundException extends RuntimeException {
    public LoanNotFoundException(String message) {
        super(message);
    }
}
