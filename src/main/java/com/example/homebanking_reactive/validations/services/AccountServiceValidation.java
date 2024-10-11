package com.example.homebanking_reactive.validations.services;

import com.example.homebanking_reactive.enums.AccountTransactionType;
import com.example.homebanking_reactive.enums.AccountType;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface AccountServiceValidation {

    Mono<UUID> validateAccountId(String accountId);

    Mono<Boolean> existsAccountByNumber(String accountNumber);

    Mono<Void> validateExistsAccountByNumber(String accountNumber);

    Mono<Void> validateExistsAccountToTransaction(String accountNumber, AccountTransactionType accountTransactionType);

    Mono<AccountType> validateAccountType(String accountType);

    Mono<String> validateAccountTypeNotEmpty(String accountType);

    Mono<Boolean> existsAccountByNumberAndBalanceGreaterThanEqual(String accountNumber, Double balance);

    Mono<Void> validateBalanceToAccount(String accountNumber, Double balance);
}
