package com.example.homebanking_reactive.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Table("client_loans")
public class ClientLoanEntity {

    @Id
    private UUID id;

    private UUID clientId, loanId;

    private Double amount;

    private int payment;

    public ClientLoanEntity() {
    }

    public ClientLoanEntity(Double amount, int payment) {
        this.amount = amount;
        this.payment = payment;
    }

    public UUID getId() {
        return id;
    }

    public UUID getClientId() {
        return clientId;
    }

    public UUID getLoanId() {
        return loanId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public void addClientId(UUID clientId) {
        this.clientId = clientId;
    }

    public void addLoanId(UUID loanId) {
        this.loanId = loanId;
    }
}
