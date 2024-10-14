package com.example.homebanking_reactive.services;

import com.example.homebanking_reactive.models.LoanPaymentModel;
import reactor.core.publisher.Flux;

import java.util.UUID;

public interface LoanPaymentService {

    Flux<LoanPaymentModel> getPaymentsByLoanId(UUID loanId);

}
