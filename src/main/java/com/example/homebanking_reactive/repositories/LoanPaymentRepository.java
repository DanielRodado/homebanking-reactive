package com.example.homebanking_reactive.repositories;

import com.example.homebanking_reactive.entities.LoanPaymentEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.util.UUID;

public interface LoanPaymentRepository extends ReactiveCrudRepository<LoanPaymentEntity, UUID> {

    Flux<LoanPaymentEntity> findByLoanId(UUID loanId);

}
