package com.example.homebanking_reactive.dto.loanDTO;

import com.example.homebanking_reactive.models.LoanPaymentModel;

import java.util.UUID;

public class LoanPaymentDTO {

    private final UUID id;
    private final int payment;

    public LoanPaymentDTO(LoanPaymentModel loanPayment) {
        this.id = loanPayment.getId();
        this.payment = loanPayment.getPayment();
    }

    public UUID getId() {
        return id;
    }

    public int getPayment() {
        return payment;
    }
}
