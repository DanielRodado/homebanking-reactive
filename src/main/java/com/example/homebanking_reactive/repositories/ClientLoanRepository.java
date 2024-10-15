package com.example.homebanking_reactive.repositories;

import com.example.homebanking_reactive.entities.ClientLoanEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.util.UUID;

public interface ClientLoanRepository extends ReactiveCrudRepository<ClientLoanEntity, UUID> {

    Flux<ClientLoanEntity> findByClientId(UUID clientId);

}
