package com.example.homebanking_reactive.services;

import com.example.homebanking_reactive.dto.loanDTO.LoanDTO;
import com.example.homebanking_reactive.models.LoanModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface LoanService {

    Flux<LoanModel> getLoans();

    Flux<LoanDTO> getLoansDTO();

    Mono<LoanDTO> getPaymentsFromLoan(LoanModel loanModel);

}
