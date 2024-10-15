package com.example.homebanking_reactive.services;

import com.example.homebanking_reactive.enums.AccountType;
import com.example.homebanking_reactive.entities.AccountEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface AccountService {

    // Methods Repository

    Mono<AccountEntity> getAccountById(String accountId);

    Mono<AccountEntity> getAccountByNumber(String accountNumber);

    Flux<AccountEntity> getAccountsByClientId(UUID clientId);

    Flux<AccountEntity> getAccounts();

    Mono<AccountEntity> saveAccount(AccountEntity account);

    // Methods Controller

    Mono<Void> createAccount(String accountType, UUID clientId);

    Mono<String> generateUniqueAccountNumber();

    Mono<String> generateAccountNumber();

    Mono<AccountEntity> generateAccount(AccountType accountType, UUID clientId);

    Mono<Void> addClientToAccount(AccountEntity account, UUID clientId);

    Mono<Void> deleteAccount(String id);
}
