package com.example.homebanking_reactive.dto.loanDTO;

import com.example.homebanking_reactive.entities.ClientLoanEntity;

import java.util.UUID;

public class ClientLoanDTO {

    private final UUID id;
    private final UUID loanId;
    private final String name;
    private final Double amount;
    private final int payments;

    public ClientLoanDTO(ClientLoanEntity clientLoan, String loanName) {
        id = clientLoan.getId();
        loanId = clientLoan.getLoanId();
        name = loanName;
        amount = clientLoan.getAmount();
        payments = clientLoan.getPayment();
    }

    public UUID getId() {
        return id;
    }

    public UUID getLoanId() {
        return loanId;
    }

    public String getName() {
        return name;
    }

    public Double getAmount() {
        return amount;
    }

    public int getPayments() {
        return payments;
    }
}
