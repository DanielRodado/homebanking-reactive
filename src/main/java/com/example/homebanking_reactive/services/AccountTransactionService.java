package com.example.homebanking_reactive.services;

import com.example.homebanking_reactive.dto.accountDTO.AccountDTO;
import com.example.homebanking_reactive.dto.transactionDTO.TransactionApplicationDTO;
import com.example.homebanking_reactive.dto.transactionDTO.TransactionDTO;
import com.example.homebanking_reactive.enums.TransactionType;
import com.example.homebanking_reactive.models.AccountModel;
import com.example.homebanking_reactive.models.TransactionModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

public interface AccountTransactionService {

    Mono<AccountDTO> getAccountDTOById(String accountId);

    Mono<List<AccountDTO>> getAccountsDTOByClientId(UUID clientId);

    Flux<AccountDTO> getAccountsDTO();

    Mono<List<TransactionDTO>> getTransactionDTOByAccountId(UUID accountId);

    Mono<AccountDTO> getTransactionsFromAccount(AccountModel account);

    // Methods Controller

    Flux<TransactionDTO> getTransactionsDTOByAccountId(String accountId);

    Flux<TransactionModel> getTransactionsByAccountId(String accountId);

    Mono<Void> createTransaction(TransactionApplicationDTO transactionAppDTO);

    Mono<TransactionModel> generateTransaction(TransactionApplicationDTO transactionAppDTO, TransactionType transactionType);

    Mono<TransactionModel> assignTransactionToAccount(TransactionModel transaction, UUID accountId);

    Mono<TransactionModel> getAccountToAssignTransaction(TransactionApplicationDTO transactionAppDTO,
                                                         String accountNumber,
                                                         TransactionType transactionType);

    Mono<AccountModel> setBalanceToAccount(AccountModel account, Double amount, TransactionType transactionType);

}
