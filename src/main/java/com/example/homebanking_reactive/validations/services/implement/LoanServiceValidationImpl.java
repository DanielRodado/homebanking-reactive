package com.example.homebanking_reactive.validations.services.implement;

import com.example.homebanking_reactive.exceptions.loanExceptions.LoanNotFoundException;
import com.example.homebanking_reactive.validations.services.LoanServiceValidation;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

import static com.example.homebanking_reactive.utils.LoanMessageUtil.LOAN_NOT_FOUND;

@Service
public class LoanServiceValidationImpl implements LoanServiceValidation {

    @Override
    public Mono<UUID> validateLoanId(String loanId) {
        return Mono.just(loanId)
                .map(UUID::fromString)
                .onErrorMap(IllegalArgumentException.class, e -> new LoanNotFoundException(LOAN_NOT_FOUND));
    }

}
