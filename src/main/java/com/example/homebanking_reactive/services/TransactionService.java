package com.example.homebanking_reactive.services;

import com.example.homebanking_reactive.dto.transactionDTO.TransactionDTO;
import com.example.homebanking_reactive.models.TransactionModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface TransactionService {

    Flux<TransactionModel> getTransactions();

    Flux<TransactionDTO> getTransactionDTOS();

    Flux<TransactionModel> getTransactionsByAccountId(UUID accountId);

    Flux<TransactionDTO> getTransactionsDTOByAccountId(UUID accountId);

    Mono<TransactionModel> saveTransaction(TransactionModel transaction);

}
