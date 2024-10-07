package com.example.homebanking_reactive.services.implement;

import com.example.homebanking_reactive.dto.clientDTO.ClientDTO;
import com.example.homebanking_reactive.services.AccountService;
import com.example.homebanking_reactive.services.ClientAccountService;
import com.example.homebanking_reactive.services.ClientService;
import com.example.homebanking_reactive.validations.services.ClientServiceValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashSet;

import static com.example.homebanking_reactive.mappers.ClientMapper.toClientDTO;

@Service
public class ClientAccountServiceImpl implements ClientAccountService {

    @Autowired
    private ClientService clientService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private ClientServiceValidation clientServiceValidation;

    @Override
    public Mono<ClientDTO> getClientDTOById(String clientId) {
        return clientService.getClientById(clientId)
                .flatMap(clientModel -> accountService
                        .getAccountsDTOByClientId(clientModel.getId())
                        .collectList()
                        .map(accounts -> toClientDTO(clientModel, new HashSet<>(accounts)))
                );
    }

    @Override
    public Flux<ClientDTO> getClientsDTO() {
        return clientService.getClients()
                .flatMap(clientModel -> accountService
                        .getAccountsDTOByClientId(clientModel.getId())
                        .collectList()
                        .map(accounts -> toClientDTO(clientModel, new HashSet<>(accounts)))
                );
    }

    public Mono<Void> createAccount(String accountType, String clientId) {
        return clientServiceValidation
                .validateClientId(clientId)
                .flatMap(uuid -> clientServiceValidation.validateExistsClientById(uuid))
                .flatMap(uuid ->  accountService.createAccount(accountType, uuid));
    };



}
