package com.example.homebanking_reactive.repositories;

import com.example.homebanking_reactive.models.TransactionModel;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.util.UUID;

public interface TransactionRepository extends ReactiveCrudRepository<TransactionModel, UUID> {

    Flux<TransactionModel> findByAccountId(UUID accountId);

}
