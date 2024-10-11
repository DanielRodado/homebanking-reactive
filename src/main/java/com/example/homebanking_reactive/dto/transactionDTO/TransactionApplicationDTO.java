package com.example.homebanking_reactive.dto.transactionDTO;

public record TransactionApplicationDTO(Double amount,
                                        String description,
                                        String sourceAccountNumber,
                                        String destinationAccountNumber) {
}
