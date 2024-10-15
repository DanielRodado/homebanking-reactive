package com.example.homebanking_reactive.services.implement;

import com.example.homebanking_reactive.dto.clientDTO.ClientDTO;
import com.example.homebanking_reactive.entities.ClientEntity;
import com.example.homebanking_reactive.services.*;
import com.example.homebanking_reactive.validations.services.ClientServiceValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.HashSet;

import static com.example.homebanking_reactive.mappers.ClientMapper.toClientDTOMono;

@Service
public class ClientAccountServiceImpl implements ClientAccountService {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountTransactionService accountTransactionService;

    @Autowired
    private ClientServiceValidation clientServiceValidation;

    @Override
    public Mono<ClientDTO> getAccountsFromClient(ClientEntity client) {
        return accountTransactionService.getAccountsDTOByClientId(client.getId())
                .flatMap(accountDTOS -> toClientDTOMono(client)
                        .flatMap(clientDTO -> {
                            clientDTO.setAccountDTOS(new HashSet<>(accountDTOS));
                            return Mono.just(clientDTO);
                        })
                );
    }

    public Mono<Void> createAccount(String accountType, String clientId) {
        return clientServiceValidation
                .validateClientId(clientId)
                .flatMap(uuid -> clientServiceValidation.validateExistsClientById(uuid))
                .flatMap(uuid ->  accountService.createAccount(accountType, uuid));
    };

}
