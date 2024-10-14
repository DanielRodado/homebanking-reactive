package com.example.homebanking_reactive.mappers;

import com.example.homebanking_reactive.dto.loanDTO.LoanDTO;
import com.example.homebanking_reactive.models.LoanModel;
import com.example.homebanking_reactive.models.LoanPaymentModel;

import java.util.List;

public final class LoanMapper {

    public static LoanDTO toLoanDTO(LoanModel loan, List<LoanPaymentModel> loanPaymentDTOS) {
        return new LoanDTO(loan, toPayment(loanPaymentDTOS));
    }

    private static List<Integer> toPayment(List<LoanPaymentModel> loanPaymentDTOS) {
        return loanPaymentDTOS.stream().map(LoanPaymentModel::getPayment).toList();
    }

}
