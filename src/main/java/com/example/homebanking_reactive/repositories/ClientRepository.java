package com.example.homebanking_reactive.repositories;

import com.example.homebanking_reactive.models.ClientModel;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface ClientRepository extends ReactiveCrudRepository<ClientModel, UUID> {

    Mono<Boolean> existsClientByEmailIgnoreCase(String clientEmail);

}
