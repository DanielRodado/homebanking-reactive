package com.example.homebanking_reactive.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Table("loans")
public class LoanEntity {

    @Id
    private UUID id;

    private String name;

    private Double maxAmount, interestRate;

    public LoanEntity() {
    }

    public LoanEntity(String name, Double maxAmount, Double interestRate) {
        this.name = name;
        this.maxAmount = maxAmount;
        this.interestRate = interestRate;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(Double maxAmount) {
        this.maxAmount = maxAmount;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }
}
