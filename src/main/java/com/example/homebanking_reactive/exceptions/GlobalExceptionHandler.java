package com.example.homebanking_reactive.exceptions;

import com.example.homebanking_reactive.exceptions.accountExceptions.AccountNotFoundException;
import com.example.homebanking_reactive.exceptions.accountExceptions.AccountNumberAlreadyExistsException;
import com.example.homebanking_reactive.exceptions.accountExceptions.AccountTypeNotValidException;
import com.example.homebanking_reactive.exceptions.accountExceptions.InsufficientBalanceException;
import com.example.homebanking_reactive.exceptions.clientExceptions.ClientEmailAlreadyExistsException;
import com.example.homebanking_reactive.exceptions.clientExceptions.ClientNotFoundException;
import com.example.homebanking_reactive.exceptions.loanExceptions.LoanNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import reactor.core.publisher.Mono;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    public Mono<ResponseEntity<String>> handleValidationException(ValidationException ex) {
        return Mono.just(ResponseEntity.badRequest().body(ex.getMessage()));
    }

    @ExceptionHandler(ClientNotFoundException.class)
    public Mono<ResponseEntity<String>> handleClientNotFoundException(ClientNotFoundException ex) {
        return Mono.just(ResponseEntity.status(404).body(ex.getMessage()));
    }

    @ExceptionHandler(ClientEmailAlreadyExistsException.class)
    public Mono<ResponseEntity<String>> handleClientEmailAlreadyExistsException(ClientEmailAlreadyExistsException ex) {
        return Mono.just(ResponseEntity.status(403).body(ex.getMessage()));
    }

    @ExceptionHandler(AccountNotFoundException.class)
    public Mono<ResponseEntity<String>> handleAccountNotFoundException(AccountNotFoundException ex) {
        return Mono.just(ResponseEntity.status(404).body(ex.getMessage()));
    }

    @ExceptionHandler(AccountTypeNotValidException.class)
    public Mono<ResponseEntity<String>> handleAccountTypeNotValidException(AccountTypeNotValidException ex) {
        return Mono.just(ResponseEntity.badRequest().body(ex.getMessage()));
    }

    @ExceptionHandler(AccountNumberAlreadyExistsException.class)
    public Mono<ResponseEntity<String>> handleAccountNumberAlreadyExistsException(AccountNumberAlreadyExistsException ex) {
        return Mono.just(ResponseEntity.status(403).body(ex.getMessage()));
    }

    @ExceptionHandler(InsufficientBalanceException.class)
    public Mono<ResponseEntity<String>> handleInsufficientBalanceException(InsufficientBalanceException ex) {
        return Mono.just(ResponseEntity.status(403).body(ex.getMessage()));
    }

    @ExceptionHandler(LoanNotFoundException.class)
    public Mono<ResponseEntity<String>> handleLoanNotFoundException(LoanNotFoundException ex) {
        return Mono.just(ResponseEntity.status(404).body(ex.getMessage()));
    }

}
