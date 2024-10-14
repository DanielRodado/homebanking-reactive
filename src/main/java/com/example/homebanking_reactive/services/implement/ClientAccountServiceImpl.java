package com.example.homebanking_reactive.services.implement;

import com.example.homebanking_reactive.dto.accountDTO.AccountDTO;
import com.example.homebanking_reactive.services.*;
import com.example.homebanking_reactive.validations.services.ClientServiceValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@Service
public class ClientAccountServiceImpl implements ClientAccountService {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountTransactionService accountTransactionService;

    @Autowired
    private ClientServiceValidation clientServiceValidation;

    @Override
    public Mono<List<AccountDTO>> getAccountsDTOFromClientId(UUID clientId) {
        return accountTransactionService
                .getAccountsDTOByClientId(clientId)
                .collectList();
    }

    public Mono<Void> createAccount(String accountType, String clientId) {
        return clientServiceValidation
                .validateClientId(clientId)
                .flatMap(uuid -> clientServiceValidation.validateExistsClientById(uuid))
                .flatMap(uuid ->  accountService.createAccount(accountType, uuid));
    };

}
