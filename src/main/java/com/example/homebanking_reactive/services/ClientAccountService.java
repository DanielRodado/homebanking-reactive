package com.example.homebanking_reactive.services;

import com.example.homebanking_reactive.dto.clientDTO.ClientDTO;
import com.example.homebanking_reactive.entities.ClientEntity;
import reactor.core.publisher.Mono;

public interface ClientAccountService {

    Mono<ClientDTO> getAccountsFromClient(ClientEntity client);

    Mono<Void> createAccount(String accountType, String clientId);

}
;