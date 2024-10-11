package com.example.homebanking_reactive.dto.accountDTO;

import com.example.homebanking_reactive.dto.transactionDTO.TransactionDTO;
import com.example.homebanking_reactive.enums.AccountType;
import com.example.homebanking_reactive.models.AccountModel;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

public class AccountDTO {

    private final UUID id;
    private final String number;
    private final Double balance;
    private final AccountType type;
    private final LocalDate creationDate;
    private Set<TransactionDTO> transactionDTOS;

    public AccountDTO(AccountModel account) {
        id = account.getId();
        number = account.getNumber();
        balance = account.getBalance();
        type = account.getType();
        creationDate = account.getCreationDate();
    }

    public AccountDTO(AccountModel account, Set<TransactionDTO> transactionDTOS) {
        id = account.getId();
        number = account.getNumber();
        balance = account.getBalance();
        type = account.getType();
        creationDate = account.getCreationDate();
        this.transactionDTOS = transactionDTOS;
    }

    public UUID getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public Double getBalance() {
        return balance;
    }

    public AccountType getType() {
        return type;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public Set<TransactionDTO> getTransactions() {
        return transactionDTOS;
    }
}
