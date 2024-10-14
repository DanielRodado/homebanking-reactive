package com.example.homebanking_reactive.services;

import com.example.homebanking_reactive.dto.accountDTO.AccountDTO;
import com.example.homebanking_reactive.dto.clientDTO.ClientDTO;
import com.example.homebanking_reactive.models.ClientModel;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

public interface ClientAccountService {

    Mono<List<AccountDTO>> getAccountsDTOFromClientId(UUID clientId);

    Mono<Void> createAccount(String accountType, String clientId);

}
