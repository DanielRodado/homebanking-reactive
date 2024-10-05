package com.example.homebanking_reactive.services;

import com.example.homebanking_reactive.validations.services.ClientServiceValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class ClientAccountService {

    @Autowired
    private ClientService clientService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private ClientServiceValidation clientServiceValidation;

    public Mono<Void> createAccount(String accountType, String clientId) {
        return clientServiceValidation
                .validateClientId(clientId)
                .flatMap(uuid -> clientServiceValidation.validateExistsClientById(uuid))
                .flatMap(uuid ->  accountService.createAccount(accountType, uuid));
    };

}
