package com.example.homebanking_reactive.dto.loanDTO;

import com.example.homebanking_reactive.entities.LoanEntity;

import java.util.List;
import java.util.UUID;

public class LoanDTO {

    private final UUID id;
    private final String name;
    private final Double maxAmount, interestRate;
    private List<Integer> payments;

    public LoanDTO(LoanEntity loan, List<Integer> payments) {
        id = loan.getId();
        name = loan.getName();
        maxAmount = loan.getMaxAmount();
        interestRate = loan.getInterestRate();
        this.payments = payments;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getMaxAmount() {
        return maxAmount;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public List<Integer> getPayments() {
        return payments;
    }
}
