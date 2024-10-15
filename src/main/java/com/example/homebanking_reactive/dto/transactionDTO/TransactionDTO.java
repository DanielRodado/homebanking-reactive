package com.example.homebanking_reactive.dto.transactionDTO;

import com.example.homebanking_reactive.enums.TransactionType;
import com.example.homebanking_reactive.entities.TransactionEntity;

import java.time.LocalDateTime;
import java.util.UUID;

public class TransactionDTO {

    private final UUID id;
    private final Double amount;
    private final TransactionType transactionType;
    private final String description;
    private final LocalDateTime dateTime;

    public TransactionDTO(TransactionEntity transaction) {
        id = transaction.getId();
        amount = transaction.getAmount();
        transactionType = transaction.getTransactionType();
        description = transaction.getDescription();
        dateTime = transaction.getDateTime();
    }

    public UUID getId() {
        return id;
    }

    public Double getAmount() {
        return amount;
    }

    public TransactionType getType() {
        return transactionType;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
