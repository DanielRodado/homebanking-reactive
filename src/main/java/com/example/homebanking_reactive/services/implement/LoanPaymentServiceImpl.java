package com.example.homebanking_reactive.services.implement;

import com.example.homebanking_reactive.dto.loanDTO.LoanPaymentDTO;
import com.example.homebanking_reactive.models.LoanPaymentModel;
import com.example.homebanking_reactive.repositories.LoanPaymentRepository;
import com.example.homebanking_reactive.services.LoanPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Service
public class LoanPaymentServiceImpl implements LoanPaymentService {

    @Autowired
    private LoanPaymentRepository loanPaymentRepository;

    @Override
    public Flux<LoanPaymentModel> getPaymentsByLoanId(UUID loanId) {
        return loanPaymentRepository.findByLoanId(loanId);
    }
}
