package com.example.homebanking_reactive.exceptions;

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

}
