package com.example.homebanking_reactive.services.implement;

import com.example.homebanking_reactive.dto.ClientApplicationDTO;
import com.example.homebanking_reactive.dto.ClientDTO;
import com.example.homebanking_reactive.exceptions.ClientNotFoundException;
import com.example.homebanking_reactive.mappers.ClientMapper;
import com.example.homebanking_reactive.models.ClientEntity;
import com.example.homebanking_reactive.repositories.ClientRepository;
import com.example.homebanking_reactive.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

import static com.example.homebanking_reactive.utils.MessageUtil.CLIENT_NOT_FOUND;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    // Methods Repository

    @Override
    public Mono<ClientEntity> getClientById(String clientId) {
        return Mono.just(clientId)
                .map(UUID::fromString)
                .flatMap(clientRepository::findById)
                .switchIfEmpty(Mono.error(new ClientNotFoundException(CLIENT_NOT_FOUND)))
                .onErrorMap(IllegalArgumentException.class, e -> new ClientNotFoundException(CLIENT_NOT_FOUND));
    }

    @Override
    public Flux<ClientEntity> getClients() {
        return clientRepository.findAll();
    }

    @Override
    public Mono<ClientEntity> saveClient(ClientEntity client) {
        return clientRepository.save(client);
    }

    // Methods repository and mapper

    @Override
    public Mono<ClientDTO> getClientDTOById(String clientId) {
        return getClientById(clientId).map(ClientMapper::toClientDTO);
    }

    @Override
    public Flux<ClientDTO> getClientsDTO() {
        return getClients().map(ClientMapper::toClientDTO);
    }

    // Methods Controller

    @Override
    public Mono<Void> createClient(Mono<ClientApplicationDTO> clientAppDTOMono) {
        return clientAppDTOMono
                .map(ClientMapper::toClient)
                .flatMap(this::saveClient)
                .then();
    }

    @Override
    public Mono<Void> deleteClient(String clientId) {
        return getClientById(clientId).flatMap(clientRepository::delete);
    }
}
