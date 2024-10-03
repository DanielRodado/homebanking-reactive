package com.example.homebanking_reactive.services;

import com.example.homebanking_reactive.dto.ClientApplicationDTO;
import com.example.homebanking_reactive.dto.ClientDTO;
import com.example.homebanking_reactive.models.ClientEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientService {

    // Methods Repository

    Mono<ClientEntity> getClientById(String clientId);

    Flux<ClientEntity> getClients();

    Mono<ClientEntity> saveClient(ClientEntity client);

    // Methods repository and mapper

    Mono<ClientDTO> getClientDTOById(String clientId);

    Flux<ClientDTO> getClientsDTO();

    // Methods Controller

    Mono<Void> createClient(ClientApplicationDTO clientAppDTO);

    Mono<Void> deleteClient(String clientId);

}
