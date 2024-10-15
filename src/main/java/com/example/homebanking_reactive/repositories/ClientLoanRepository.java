package com.example.homebanking_reactive.repositories;

import com.example.homebanking_reactive.models.ClientLoanModel;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.util.UUID;

public interface ClientLoanRepository extends ReactiveCrudRepository<ClientLoanModel, UUID> {

    Flux<ClientLoanModel> findByClientId(UUID clientId);

}
