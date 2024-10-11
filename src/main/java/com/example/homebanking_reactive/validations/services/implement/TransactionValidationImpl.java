package com.example.homebanking_reactive.validations.services.implement;

import com.example.homebanking_reactive.dto.transactionDTO.TransactionApplicationDTO;
import com.example.homebanking_reactive.enums.AccountTransactionType;
import com.example.homebanking_reactive.validations.TransactionAppValidator;
import com.example.homebanking_reactive.validations.services.AccountServiceValidation;
import com.example.homebanking_reactive.validations.services.TransactionServiceValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class TransactionValidationImpl implements TransactionServiceValidation {

    @Autowired
    private AccountServiceValidation accountServiceValidation;

    @Autowired
    private TransactionAppValidator transactionAppValidator;

    @Override
    public Mono<Void> validateTransactionApplicationDTO(TransactionApplicationDTO transactionApp) {
        return transactionAppValidator(transactionApp)
                .flatMap(transactionAppDTO -> accountServiceValidation
                        .validateExistsAccountToTransaction(
                                "V-"+transactionAppDTO.sourceAccountNumber(),
                                AccountTransactionType.SOURCE
                        )
                        .thenReturn(transactionAppDTO)
                )
                .flatMap(transactionAppDTO -> accountServiceValidation
                        .validateExistsAccountToTransaction(
                                "V-"+transactionAppDTO.destinationAccountNumber(),
                                AccountTransactionType.DESTINATION
                        )
                        .thenReturn(transactionAppDTO)
                )
                .flatMap(transactionApplicationDTO -> accountServiceValidation
                        .validateBalanceToAccount(
                                "V-"+transactionApplicationDTO.sourceAccountNumber(),
                                transactionApplicationDTO.amount()
                        ))
                .then();
    }

    @SuppressWarnings("DataFlowIssue")
    @Override
    public Mono<TransactionApplicationDTO> transactionAppValidator(TransactionApplicationDTO transactionApp) {
        transactionAppValidator.validate(transactionApp, null);
        return Mono.just(transactionApp);
    }
}
