package com.example.homebanking_reactive.validations.services.implement;

import com.example.homebanking_reactive.enums.AccountType;
import com.example.homebanking_reactive.exceptions.accountExceptions.AccountNotFoundException;
import com.example.homebanking_reactive.exceptions.accountExceptions.AccountTypeNotValidException;
import com.example.homebanking_reactive.repositories.AccountRepository;
import com.example.homebanking_reactive.validations.services.AccountServiceValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

import static com.example.homebanking_reactive.utils.MessageUtil.*;

@Service
public class AccountServiceValidationImpl implements AccountServiceValidation {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Mono<UUID> validateAccountId(String accountId) {
        return Mono.just(accountId)
                .map(UUID::fromString)
                .onErrorMap(IllegalArgumentException.class, e -> new AccountNotFoundException(ACCOUNT_NOT_FOUND));
    }

    @Override
    public Mono<Boolean> existsAccountByNumber(String accountNumber) {
        return accountRepository.existsByNumber(accountNumber);
    }

    @Override
    public Mono<AccountType> validateAccountType(String accountType) {
        return validateAccountTypeNotEmpty(accountType)
                .map(AccountType::valueOf)
                .onErrorMap(IllegalArgumentException.class, e -> new AccountTypeNotValidException(ACCOUNT_TYPE_INVALID));
    }

    @Override
    public Mono<String> validateAccountTypeNotEmpty(String accountType) {
        return accountType.isBlank() ? Mono.error(new AccountTypeNotValidException(ACCOUNT_TYPE_EMPTY)) : Mono.just(accountType);
    }
}
