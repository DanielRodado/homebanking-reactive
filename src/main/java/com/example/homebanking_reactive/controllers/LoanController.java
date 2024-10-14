package com.example.homebanking_reactive.controllers;

import com.example.homebanking_reactive.dto.loanDTO.LoanDTO;
import com.example.homebanking_reactive.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @GetMapping
    public Flux<LoanDTO> getLoansDTO() {
        return loanService.getLoansDTO();
    }

}
