package com.example.homebanking_reactive.validations.services;

import com.example.homebanking_reactive.enums.AccountType;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface AccountServiceValidation {

    Mono<UUID> validateAccountId(String accountId);

    Mono<Boolean> existsAccountByNumber(String accountNumber);

    Mono<AccountType> validateAccountType(String accountType);

    Mono<String> validateAccountTypeNotEmpty(String accountType);
}
