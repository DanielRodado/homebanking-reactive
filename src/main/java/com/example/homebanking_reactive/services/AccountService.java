package com.example.homebanking_reactive.services;

import com.example.homebanking_reactive.dto.accountDTO.AccountDTO;
import com.example.homebanking_reactive.enums.AccountType;
import com.example.homebanking_reactive.models.AccountModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface AccountService {

    // Methods Repository

    Mono<AccountModel> getAccountById(String accountId);

    Flux<AccountModel> getAccounts();

    Mono<AccountModel> saveAccount(AccountModel account);

    // Methods repository and mapper

    Mono<AccountDTO> getAccountDTOById(String accountId);

    Flux<AccountDTO> getAccountsDTO();

    // Methods Controller

    Mono<Void> createAccount(String accountType, UUID clientId);

    Mono<String> generateUniqueAccountNumber();

    Mono<String> generateAccountNumber();

    Mono<AccountModel> generateAccount(AccountType accountType, UUID clientId);

    Mono<Void> addClientToAccount(AccountModel account, UUID clientId);

    Mono<Void> deleteAccount(String id);
}
