package com.example.homebanking_reactive.services;

import com.example.homebanking_reactive.dto.clientDTO.ClientDTO;
import com.example.homebanking_reactive.dto.loanDTO.ClientLoanDTO;
import com.example.homebanking_reactive.models.ClientLoanModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

public interface ClientLoanService {

    Flux<ClientLoanModel> getClientLoansByClientId(UUID clientId);

    Mono<List<ClientLoanDTO>> getClientLoansDTOByClientId(UUID clientId);

    Mono<ClientDTO> getClientLoansFromClient(ClientDTO clientDTO);

    Mono<ClientLoanModel> saveClientLoan(ClientLoanModel clientLoan);

}
