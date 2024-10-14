package com.example.homebanking_reactive.services;

import com.example.homebanking_reactive.dto.accountDTO.AccountDTO;
import com.example.homebanking_reactive.dto.transactionDTO.TransactionApplicationDTO;
import com.example.homebanking_reactive.dto.transactionDTO.TransactionDTO;
import com.example.homebanking_reactive.enums.TransactionType;
import com.example.homebanking_reactive.models.AccountModel;
import com.example.homebanking_reactive.models.TransactionModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface AccountTransactionService {

    Flux<AccountDTO> getAccountDTOS();

    Flux<AccountDTO> getAccountsDTOByClientId(UUID clientId);

    Flux<TransactionModel> getTransactionsByAccountId(String accountId);

    Flux<TransactionDTO> getTransactionsDTOByAccountId(String accountId);

    Mono<AccountDTO> getTransactionFromAccount(AccountModel accountModel);

    Mono<Void> createTransaction(TransactionApplicationDTO transactionAppDTO);

    Mono<TransactionModel> generateTransaction(TransactionApplicationDTO transactionAppDTO, TransactionType transactionType);

    Mono<TransactionModel> assignTransactionToAccount(TransactionModel transaction, UUID accountId);

    Mono<TransactionModel> getAccountToAssignTransaction(TransactionApplicationDTO transactionAppDTO,
                                                         String accountNumber,
                                                         TransactionType transactionType);

    Mono<AccountModel> setBalanceToAccount(AccountModel account, Double amount, TransactionType transactionType);

}
