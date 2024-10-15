package com.example.homebanking_reactive.repositories;

import com.example.homebanking_reactive.entities.TransactionEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.util.UUID;

public interface TransactionRepository extends ReactiveCrudRepository<TransactionEntity, UUID> {

    Flux<TransactionEntity> findByAccountId(UUID accountId);

}
