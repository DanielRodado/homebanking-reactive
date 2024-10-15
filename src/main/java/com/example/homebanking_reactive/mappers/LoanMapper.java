package com.example.homebanking_reactive.mappers;

import com.example.homebanking_reactive.dto.loanDTO.LoanDTO;
import com.example.homebanking_reactive.entities.LoanEntity;
import com.example.homebanking_reactive.entities.LoanPaymentEntity;

import java.util.List;

public final class LoanMapper {

    public static LoanDTO toLoanDTO(LoanEntity loan, List<LoanPaymentEntity> loanPaymentDTOS) {
        return new LoanDTO(loan, toPayment(loanPaymentDTOS));
    }

    private static List<Integer> toPayment(List<LoanPaymentEntity> loanPaymentDTOS) {
        return loanPaymentDTOS.stream().map(LoanPaymentEntity::getPayment).toList();
    }

}
