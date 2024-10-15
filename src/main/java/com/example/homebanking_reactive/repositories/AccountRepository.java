package com.example.homebanking_reactive.repositories;

import com.example.homebanking_reactive.entities.AccountEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface AccountRepository extends ReactiveCrudRepository<AccountEntity, UUID> {

    Mono<Boolean> existsByNumber(String accountNumber);

    Mono<Boolean> existsByNumberAndBalanceGreaterThanEqual(String accountNumber, Double balance);

    Mono<AccountEntity> findByNumber(String accountNumber);

    Flux<AccountEntity> findByClientId(UUID clientId);

}
