package com.example.homebanking_reactive.repositories;

import com.example.homebanking_reactive.models.LoanPaymentModel;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.util.UUID;

public interface LoanPaymentRepository extends ReactiveCrudRepository<LoanPaymentModel, UUID> {

    Flux<LoanPaymentModel> findByLoanId(UUID loanId);

}
