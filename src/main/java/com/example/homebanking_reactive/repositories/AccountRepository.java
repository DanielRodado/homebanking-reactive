package com.example.homebanking_reactive.repositories;

import com.example.homebanking_reactive.models.AccountModel;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface AccountRepository extends ReactiveCrudRepository<AccountModel, UUID> {

    Mono<Boolean> existsByNumber(String accountNumber);

    Mono<Boolean> existsByNumberAndBalanceGreaterThanEqual(String accountNumber, Double balance);

    Mono<AccountModel> findByNumber(String accountNumber);

    Flux<AccountModel> findByClientId(UUID clientId);

}
