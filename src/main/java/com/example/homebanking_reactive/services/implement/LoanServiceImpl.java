package com.example.homebanking_reactive.services.implement;

import com.example.homebanking_reactive.dto.loanDTO.LoanDTO;
import com.example.homebanking_reactive.models.LoanModel;
import com.example.homebanking_reactive.repositories.LoanRepository;
import com.example.homebanking_reactive.services.LoanPaymentService;
import com.example.homebanking_reactive.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.example.homebanking_reactive.mappers.LoanMapper.toLoanDTO;

@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private LoanPaymentService loanPaymentService;

    @Override
    public Flux<LoanModel> getLoans() {
        return loanRepository.findAll();
    }

    @Override
    public Flux<LoanDTO> getLoansDTO() {
        return getLoans().flatMap(this::getPaymentsFromLoan);
    }

    @Override
    public Mono<LoanDTO> getPaymentsFromLoan(LoanModel loanModel) {
        return loanPaymentService
                .getPaymentsByLoanId(loanModel.getId())
                .collectList()
                .map(loanPaymentModels -> toLoanDTO(loanModel, loanPaymentModels));
    }
}