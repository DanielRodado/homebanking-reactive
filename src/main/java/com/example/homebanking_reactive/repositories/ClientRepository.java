package com.example.homebanking_reactive.repositories;

import com.example.homebanking_reactive.models.ClientEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface ClientRepository extends ReactiveCrudRepository<ClientEntity, UUID> {

    Mono<Boolean> existsClientByEmailIgnoreCase(String clientEmail);

}
