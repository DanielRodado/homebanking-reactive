package com.example.homebanking_reactive.services;

import com.example.homebanking_reactive.entities.LoanPaymentEntity;
import reactor.core.publisher.Flux;

import java.util.UUID;

public interface LoanPaymentService {

    Flux<LoanPaymentEntity> getPaymentsByLoanId(UUID loanId);

}
