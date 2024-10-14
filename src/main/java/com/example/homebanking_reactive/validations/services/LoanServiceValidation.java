package com.example.homebanking_reactive.validations.services;

import reactor.core.publisher.Mono;

import java.util.UUID;

public interface LoanServiceValidation {

    Mono<UUID> validateLoanId(String loanId);

}
