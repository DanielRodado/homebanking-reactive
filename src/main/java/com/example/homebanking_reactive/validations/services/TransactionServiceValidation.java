package com.example.homebanking_reactive.validations.services;

import com.example.homebanking_reactive.dto.transactionDTO.TransactionApplicationDTO;
import reactor.core.publisher.Mono;

public interface TransactionServiceValidation {

    Mono<Void> validateTransactionApplicationDTO(TransactionApplicationDTO transactionApp);

    Mono<TransactionApplicationDTO> transactionAppValidator(TransactionApplicationDTO transactionApp);

}
