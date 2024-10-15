package com.example.homebanking_reactive.services;

import com.example.homebanking_reactive.dto.accountDTO.AccountDTO;
import com.example.homebanking_reactive.dto.transactionDTO.TransactionApplicationDTO;
import com.example.homebanking_reactive.dto.transactionDTO.TransactionDTO;
import com.example.homebanking_reactive.enums.TransactionType;
import com.example.homebanking_reactive.entities.AccountEntity;
import com.example.homebanking_reactive.entities.TransactionEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

public interface AccountTransactionService {

    Mono<List<TransactionDTO>> getTransactionDTOByAccountId(UUID accountId);

    Mono<AccountDTO> getTransactionsFromAccount(AccountEntity account);

    Mono<AccountDTO> getAccountDTOById(String accountId);

    Mono<List<AccountDTO>> getAccountsDTOByClientId(UUID clientId);

    Flux<AccountDTO> getAccountsDTO();

    // Methods Controller

    Flux<TransactionDTO> getTransactionsDTOByAccountId(String accountId);

    Flux<TransactionEntity> getTransactionsByAccountId(String accountId);

    Mono<Void> createTransaction(TransactionApplicationDTO transactionAppDTO);

    Mono<TransactionEntity> generateTransaction(TransactionApplicationDTO transactionAppDTO, TransactionType transactionType);

    Mono<TransactionEntity> assignTransactionToAccount(TransactionEntity transaction, UUID accountId);

    Mono<TransactionEntity> getAccountToAssignTransaction(TransactionApplicationDTO transactionAppDTO,
                                                          String accountNumber,
                                                          TransactionType transactionType);

    Mono<AccountEntity> setBalanceToAccount(AccountEntity account, Double amount, TransactionType transactionType);

}
