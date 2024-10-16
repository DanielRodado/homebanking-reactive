package com.example.homebanking_reactive.repositories;

import com.example.homebanking_reactive.entities.CardEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.util.UUID;

public interface CardRepository extends ReactiveCrudRepository<CardEntity, UUID> {

    Flux<CardEntity> findByClientId(UUID clientId);

}
