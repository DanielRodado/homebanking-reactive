package com.example.homebanking_reactive.entities;

import com.example.homebanking_reactive.enums.AccountType;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.UUID;

@Table("accounts")
public class AccountEntity {

    @Id
    private UUID id;

    private String number;
    private Double balance;
    private AccountType type;
    private LocalDate creationDate;
    private UUID clientId;

    public AccountEntity() {
    }

    public AccountEntity(String number, Double balance, AccountType type, LocalDate creationDate) {
        this.number = number;
        this.balance = balance;
        this.type = type;
        this.creationDate = creationDate;
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

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public UUID getClientId() {
        return clientId;
    }

    @Override
    public String toString() {
        return "AccountModel{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", balance=" + balance +
                ", type=" + type +
                ", creationDate=" + creationDate +
                ", clientId=" + clientId +
                '}';
    }

    public void addClientId(UUID clientId) {
        this.clientId = clientId;
    }
}
