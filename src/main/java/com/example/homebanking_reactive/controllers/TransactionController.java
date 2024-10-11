package com.example.homebanking_reactive.controllers;

import com.example.homebanking_reactive.dto.transactionDTO.TransactionApplicationDTO;
import com.example.homebanking_reactive.dto.transactionDTO.TransactionDTO;
import com.example.homebanking_reactive.services.AccountTransactionService;
import com.example.homebanking_reactive.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

import static com.example.homebanking_reactive.utils.TransactionMessageUtil.transactionCompleted;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private AccountTransactionService accountTransactionService;

    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public Flux<TransactionDTO> getTransactionDTOS() {
        return transactionService.getTransactionDTOS();
    }

    @GetMapping("/{accountId}")
    public Flux<TransactionDTO> getTransactionsFromAccount(@PathVariable String accountId) {
        return transactionService.getTransactionsDTOByAccountId(UUID.fromString(accountId));
    }

    @PostMapping
    public Mono<ResponseEntity<String>> createTransaction(@RequestBody TransactionApplicationDTO transactionApp) {
        return accountTransactionService
                .createTransaction(transactionApp)
                .thenReturn(ResponseEntity.status(201).body(transactionCompleted(transactionApp.amount(), transactionApp.destinationAccountNumber())));
    }

}