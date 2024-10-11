package com.example.homebanking_reactive.services.implement;

import com.example.homebanking_reactive.dto.clientDTO.ClientDTO;
import com.example.homebanking_reactive.models.ClientModel;
import com.example.homebanking_reactive.services.*;
import com.example.homebanking_reactive.validations.services.ClientServiceValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.example.homebanking_reactive.mappers.ClientMapper.toClientDTO;

@Service
public class ClientAccountServiceImpl implements ClientAccountService {

    @Autowired
    private ClientService clientService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountTransactionService accountTransactionService;

    @Autowired
    private ClientServiceValidation clientServiceValidation;

    @Override
    public Mono<ClientDTO> getClientDTOById(String clientId) {
        return clientService.getClientById(clientId).flatMap(this::getAccountsFromClient);
    }

    @Override
    public Flux<ClientDTO> getClientsDTO() {
        return clientService.getClients().flatMap(this::getAccountsFromClient);
    }

    @Override
    public Mono<ClientDTO> getAccountsFromClient(ClientModel client) {
        return accountTransactionService
                .getAccountsDTOByClientId(client.getId())
                .collectList()
                .map(accountDTOS -> toClientDTO(client, accountDTOS));
    }

    public Mono<Void> createAccount(String accountType, String clientId) {
        return clientServiceValidation
                .validateClientId(clientId)
                .flatMap(uuid -> clientServiceValidation.validateExistsClientById(uuid))
                .flatMap(uuid ->  accountService.createAccount(accountType, uuid));
    };

}
