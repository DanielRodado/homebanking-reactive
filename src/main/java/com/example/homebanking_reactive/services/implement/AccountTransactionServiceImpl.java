package com.example.homebanking_reactive.services.implement;

import com.example.homebanking_reactive.dto.transactionDTO.TransactionApplicationDTO;
import com.example.homebanking_reactive.dto.transactionDTO.TransactionDTO;
import com.example.homebanking_reactive.enums.TransactionType;
import com.example.homebanking_reactive.models.AccountModel;
import com.example.homebanking_reactive.models.TransactionModel;
import com.example.homebanking_reactive.services.AccountService;
import com.example.homebanking_reactive.services.AccountTransactionService;
import com.example.homebanking_reactive.services.TransactionService;
import com.example.homebanking_reactive.validations.services.AccountServiceValidation;
import com.example.homebanking_reactive.validations.services.TransactionServiceValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

import static com.example.homebanking_reactive.mappers.TransactionMapper.toTransaction;

@Service
public class AccountTransactionServiceImpl implements AccountTransactionService {

    @Autowired
    private AccountService accountService;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private AccountServiceValidation accountServiceValidation;

    @Autowired
    private TransactionServiceValidation transactionServiceValidation;

    @Override
    public Mono<List<TransactionDTO>> getTransactionDTOByAccountId(UUID accountId) {
        return transactionService
                .getTransactionsDTOByAccountId(accountId)
                .collectList();
    }

    @Override
    public Flux<TransactionModel> getTransactionsByAccountId(String accountId) {
        return accountServiceValidation.validateAccountId(accountId).flatMapMany(transactionService::getTransactionsByAccountId);
    }

    @Override
    public Flux<TransactionDTO> getTransactionsDTOByAccountId(String accountId) {
        return getTransactionsByAccountId(accountId).map(TransactionDTO::new);
    }

    @Override
    public Mono<Void> createTransaction(TransactionApplicationDTO transactionAppDTO) {
        return transactionServiceValidation
                .validateTransactionApplicationDTO(transactionAppDTO)
                .thenReturn(transactionAppDTO)
                .flatMap(transactionApplicationDTO ->
                        getAccountToAssignTransaction(transactionApplicationDTO, transactionApplicationDTO.sourceAccountNumber(), TransactionType.DEBIT)
                                .flatMap(transactionService::saveTransaction)
                                .thenReturn(transactionApplicationDTO)
                )
                .flatMap(transactionApplicationDTO ->
                        getAccountToAssignTransaction(transactionApplicationDTO, transactionApplicationDTO.destinationAccountNumber(), TransactionType.CREDIT)
                                .flatMap(transactionService::saveTransaction)
                                .thenReturn(transactionApplicationDTO)
                )
                .then();
    }

    @Override
    public Mono<TransactionModel> generateTransaction(TransactionApplicationDTO transactionAppDTO, TransactionType transactionType) {
        return Mono.just(toTransaction(transactionAppDTO, transactionType));
    }

    @Override
    public Mono<TransactionModel> assignTransactionToAccount(TransactionModel transaction, UUID accountId) {
        transaction.addAccount(accountId);
        return Mono.just(transaction);
    }

    @Override
    public Mono<TransactionModel> getAccountToAssignTransaction(TransactionApplicationDTO transactionAppDTO,
                                                                String accountNumber,
                                                                TransactionType transactionType) {
        return accountService
                .getAccountByNumber("V-"+accountNumber)
                .flatMap(accountModel ->
                        setBalanceToAccount(accountModel, transactionAppDTO.amount(), transactionType)
                                .flatMap(accountService::saveAccount)
                                .flatMap(account -> generateTransaction(transactionAppDTO, transactionType)
                                        .flatMap(transactionModel -> assignTransactionToAccount(transactionModel, account.getId()))
                                )
                );
    }

    @Override
    public Mono<AccountModel> setBalanceToAccount(AccountModel account, Double amount, TransactionType transactionType) {
        account.setBalance(transactionType.equals(TransactionType.DEBIT)
                ? account.getBalance() - amount
                : account.getBalance() + amount);
        return Mono.just(account);
    }

}
