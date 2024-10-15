package com.example.homebanking_reactive.entities;

import com.example.homebanking_reactive.enums.TransactionType;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Table("transactions")
public class TransactionEntity {

    @Id
    private UUID id;

    private Double amount;

    @Column("type")
    private TransactionType transactionType;

    private String description;
    private LocalDateTime dateTime;
    private UUID accountId;

    public TransactionEntity() {
    }

    public TransactionEntity(Double amount, TransactionType transactionType, String description, LocalDateTime dateTime) {
        this.amount = amount;
        this.transactionType = transactionType;
        this.description = description;
        this.dateTime = dateTime;
    }

    public UUID getId() {
        return id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public void addAccount(UUID accountId) {
        this.accountId = accountId;
    }
}
