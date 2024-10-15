package com.example.homebanking_reactive.services.implement;

import com.example.homebanking_reactive.dto.clientDTO.ClientApplicationDTO;
import com.example.homebanking_reactive.dto.clientDTO.ClientDTO;
import com.example.homebanking_reactive.exceptions.clientExceptions.ClientNotFoundException;
import com.example.homebanking_reactive.mappers.ClientMapper;
import com.example.homebanking_reactive.entities.ClientEntity;
import com.example.homebanking_reactive.repositories.ClientRepository;
import com.example.homebanking_reactive.services.ClientAccountService;
import com.example.homebanking_reactive.services.ClientLoanService;
import com.example.homebanking_reactive.services.ClientService;
import com.example.homebanking_reactive.validations.services.ClientServiceValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.example.homebanking_reactive.utils.ClientMessageUtil.CLIENT_NOT_FOUND;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientAccountService clientAccountService;

    @Autowired
    private ClientLoanService clientLoanService;

    @Autowired
    private ClientServiceValidation clientServiceValidation;

    // Methods Repository

    @Override
    public Mono<ClientEntity> getClientById(String clientId) {
        return clientServiceValidation.validateClientId(clientId)
                .flatMap(clientRepository::findById)
                .switchIfEmpty(Mono.error(new ClientNotFoundException(CLIENT_NOT_FOUND)));
    }

    @Override
    public Flux<ClientEntity> getClients() {
        return clientRepository.findAll();
    }

    @Override
    public Mono<ClientEntity> saveClient(ClientEntity client) {
        return clientRepository.save(client);
    }


    // Methods Return DTO

    @Override
    public Mono<ClientDTO> getClientDTOById(String clientId) {
        return getClientById(clientId)
                .flatMap(clientAccountService::getAccountsFromClient)
                .flatMap(clientLoanService::getClientLoansFromClient);
    }

    @Override
    public Flux<ClientDTO> getClientsDTO() {
        return getClients()
                .flatMap(clientAccountService::getAccountsFromClient)
                .flatMap(clientLoanService::getClientLoansFromClient);
    }

    // Methods Controller

    @Override
    public Mono<Void> createClient(ClientApplicationDTO clientAppDTO) {
        return clientServiceValidation.validateClientApplicationDTO(clientAppDTO)
                .map(ClientMapper::toClient)
                .flatMap(this::saveClient)
                .then();
    }

    @Override
    public Mono<Void> deleteClient(String clientId) {
        return getClientById(clientId).flatMap(clientRepository::delete);
    }
}
