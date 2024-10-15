package com.example.homebanking_reactive.services;

import com.example.homebanking_reactive.dto.transactionDTO.TransactionDTO;
import com.example.homebanking_reactive.entities.TransactionEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface TransactionService {

    Flux<TransactionEntity> getTransactionsByAccountId(UUID accountId);

    Flux<TransactionDTO> getTransactionsDTOByAccountId(UUID accountId);

    Mono<TransactionEntity> saveTransaction(TransactionEntity transaction);

}
