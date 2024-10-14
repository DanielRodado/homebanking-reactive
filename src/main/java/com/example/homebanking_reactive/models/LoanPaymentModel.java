package com.example.homebanking_reactive.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Table("loan_payments")
public class LoanPaymentModel {

    @Id
    private UUID id;

    private int payment;

    private UUID loanId;

    public LoanPaymentModel() {
    }

    public LoanPaymentModel(int payment) {
        this.payment = payment;
    }

    public UUID getId() {
        return id;
    }

    public int getPayment() {
        return payment;
    }

    public UUID getLoanId() {
        return loanId;
    }

    public void addLoan(UUID loanId) {
        this.loanId = loanId;
    }
}
