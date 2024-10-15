package com.example.homebanking_reactive.services;

import com.example.homebanking_reactive.dto.clientDTO.ClientDTO;
import com.example.homebanking_reactive.dto.loanDTO.ClientLoanDTO;
import com.example.homebanking_reactive.entities.ClientLoanEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

public interface ClientLoanService {

    Flux<ClientLoanEntity> getClientLoansByClientId(UUID clientId);

    Mono<List<ClientLoanDTO>> getClientLoansDTOByClientId(UUID clientId);

    Mono<ClientDTO> getClientLoansFromClient(ClientDTO clientDTO);

    Mono<ClientLoanEntity> saveClientLoan(ClientLoanEntity clientLoan);

}
