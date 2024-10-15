package com.example.homebanking_reactive.services.implement;

import com.example.homebanking_reactive.dto.transactionDTO.TransactionDTO;
import com.example.homebanking_reactive.entities.TransactionEntity;
import com.example.homebanking_reactive.repositories.TransactionRepository;
import com.example.homebanking_reactive.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Flux<TransactionEntity> getTransactionsByAccountId(UUID accountId) {
        return transactionRepository.findByAccountId(accountId);
    }

    @Override
    public Flux<TransactionDTO> getTransactionsDTOByAccountId(UUID accountId) {
        return getTransactionsByAccountId(accountId).map(TransactionDTO::new);
    }

    @Override
    public Mono<TransactionEntity> saveTransaction(TransactionEntity transaction) {
        return transactionRepository.save(transaction);
    }

}
