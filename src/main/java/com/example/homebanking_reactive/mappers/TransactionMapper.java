package com.example.homebanking_reactive.mappers;

import com.example.homebanking_reactive.dto.transactionDTO.TransactionApplicationDTO;
import com.example.homebanking_reactive.enums.TransactionType;
import com.example.homebanking_reactive.models.TransactionModel;

import java.time.LocalDateTime;

public final class TransactionMapper {

    public static TransactionModel toTransaction(TransactionApplicationDTO transactionApp, TransactionType transactionType) {
        return new TransactionModel(
                transactionApp.amount(),
                transactionType,
                transactionApp.description(),
                LocalDateTime.now());
    }

}
