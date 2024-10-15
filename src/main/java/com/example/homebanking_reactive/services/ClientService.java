package com.example.homebanking_reactive.services;

import com.example.homebanking_reactive.dto.clientDTO.ClientApplicationDTO;
import com.example.homebanking_reactive.dto.clientDTO.ClientDTO;
import com.example.homebanking_reactive.entities.ClientEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientService {

    // Methods Repository

    Mono<ClientEntity> getClientById(String clientId);

    Flux<ClientEntity> getClients();

    Mono<ClientEntity> saveClient(ClientEntity client);

    // Methods Return DTO

    Mono<ClientDTO> getClientDTOById(String clientId);

    Flux<ClientDTO> getClientsDTO();

    // Methods Controller

    Mono<Void> createClient(ClientApplicationDTO clientAppDTO);

    Mono<Void> deleteClient(String clientId);

}
