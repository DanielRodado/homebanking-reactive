package com.example.homebanking_reactive.services.implement;

import com.example.homebanking_reactive.enums.AccountType;
import com.example.homebanking_reactive.exceptions.accountExceptions.AccountNotFoundException;
import com.example.homebanking_reactive.exceptions.accountExceptions.AccountNumberAlreadyExistsException;
import com.example.homebanking_reactive.entities.AccountEntity;
import com.example.homebanking_reactive.repositories.AccountRepository;
import com.example.homebanking_reactive.services.AccountService;
import com.example.homebanking_reactive.utils.AccountUtil;
import com.example.homebanking_reactive.validations.services.AccountServiceValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.UUID;

import static com.example.homebanking_reactive.utils.AccountMessageUtil.ACCOUNT_NOT_FOUND;
import static com.example.homebanking_reactive.utils.AccountMessageUtil.ACCOUNT_NUMBER_ERROR;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountServiceValidation accountServiceValidation;

    // Methods Repository

    @Override
    public Mono<AccountEntity> getAccountById(String accountId) {
        return accountServiceValidation.validateAccountId(accountId)
                .flatMap(accountRepository::findById)
                .switchIfEmpty(Mono.error(new AccountNotFoundException(ACCOUNT_NOT_FOUND)));
    }

    @Override
    public Mono<AccountEntity> getAccountByNumber(String accountNumber) {
        return accountRepository
                .findByNumber(accountNumber)
                .switchIfEmpty(Mono.error(new AccountNotFoundException(ACCOUNT_NOT_FOUND)));
    }

    @Override
    public Flux<AccountEntity> getAccountsByClientId(UUID clientId) {
        return accountRepository.findByClientId(clientId);
    }

    @Override
    public Flux<AccountEntity> getAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Mono<AccountEntity> saveAccount(AccountEntity account) {
        return accountRepository.save(account);
    }

    // Methods Controller

    @Override
    public Mono<Void> createAccount(String accountType, UUID clientId) {
        return accountServiceValidation.validateAccountType(accountType)
                .flatMap(type -> generateAccount(type, clientId))
                .flatMap(this::saveAccount)
                .then();
    }

    @Override
    public Mono<String> generateUniqueAccountNumber() {
        return Mono.defer(this::generateAccountNumber)
                .flatMap(accountNumber -> accountServiceValidation.existsAccountByNumber(accountNumber)
                .flatMap(exists -> exists
                                ? Mono.error(new AccountNumberAlreadyExistsException(ACCOUNT_NUMBER_ERROR))
                                : Mono.just(accountNumber)
                        ))
                .retry(5);
    }

    @Override
    public Mono<String> generateAccountNumber() {
        return Mono.just(AccountUtil.generateAccountNumber());
    }

    @Override
    public Mono<AccountEntity> generateAccount(AccountType accountType, UUID clientId) {
        return generateUniqueAccountNumber()
                .flatMap(accountNumber -> Mono.just(new AccountEntity(accountNumber, 0.0, accountType,
                        LocalDate.now())))
                .flatMap(accountModel -> addClientToAccount(accountModel, clientId)
                        .thenReturn(accountModel)
                );
    }

    @Override
    public Mono<Void> addClientToAccount(AccountEntity account, UUID clientId) {
        account.addClientId(clientId);
        return Mono.empty();
    }

    @Override
    public Mono<Void> deleteAccount(String id) {
        return getAccountById(id).flatMap(accountRepository::delete);
    }
}
