package com.example.homebanking_reactive.dto.accountDTO;

import com.example.homebanking_reactive.enums.AccountType;
import com.example.homebanking_reactive.models.AccountModel;

import java.time.LocalDate;
import java.util.UUID;

public class AccountDTO {

    private final UUID id;
    private final String number;
    private final double balance;
    private final AccountType type;
    private final LocalDate creationDate;

    public AccountDTO(AccountModel account) {
        id = account.getId();
        number = account.getNumber();
        balance = account.getBalance();
        type = account.getType();
        creationDate = account.getCreationDate();
    }

    public UUID getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public double getBalance() {
        return balance;
    }

    public AccountType getType() {
        return type;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }
}
