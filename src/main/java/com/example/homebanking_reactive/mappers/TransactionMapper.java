package com.example.homebanking_reactive.mappers;

import com.example.homebanking_reactive.dto.transactionDTO.TransactionApplicationDTO;
import com.example.homebanking_reactive.enums.TransactionType;
import com.example.homebanking_reactive.entities.TransactionEntity;

import java.time.LocalDateTime;

public final class TransactionMapper {

    public static TransactionEntity toTransaction(TransactionApplicationDTO transactionApp, TransactionType transactionType) {
        return new TransactionEntity(
                transactionApp.amount(),
                transactionType,
                transactionApp.description(),
                LocalDateTime.now());
    }

}
