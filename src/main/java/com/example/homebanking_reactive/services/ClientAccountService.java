package com.example.homebanking_reactive.services;

import com.example.homebanking_reactive.dto.clientDTO.ClientDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientAccountService {

    Mono<ClientDTO> getClientDTOById(String clientId);

    Flux<ClientDTO> getClientsDTO();

    Mono<Void> createAccount(String accountType, String clientId);

}
