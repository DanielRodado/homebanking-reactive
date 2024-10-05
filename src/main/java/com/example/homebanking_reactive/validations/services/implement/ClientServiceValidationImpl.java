package com.example.homebanking_reactive.validations.services.implement;

import com.example.homebanking_reactive.dto.clientDTO.ClientApplicationDTO;
import com.example.homebanking_reactive.exceptions.clientExceptions.ClientEmailAlreadyExistsException;
import com.example.homebanking_reactive.exceptions.clientExceptions.ClientNotFoundException;
import com.example.homebanking_reactive.repositories.ClientRepository;
import com.example.homebanking_reactive.validations.ClientAppValidator;
import com.example.homebanking_reactive.validations.services.ClientServiceValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

import static com.example.homebanking_reactive.utils.MessageUtil.CLIENT_EMAIL_EXIST;
import static com.example.homebanking_reactive.utils.MessageUtil.CLIENT_NOT_FOUND;

@Service
public class ClientServiceValidationImpl implements ClientServiceValidation {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientAppValidator clientAppValidator;

    @Override
    public Mono<UUID> validateClientId(String clientId) {
        return Mono.just(clientId)
                .map(UUID::fromString)
                .onErrorMap(IllegalArgumentException.class, e -> new ClientNotFoundException(CLIENT_NOT_FOUND));
    }

    @Override
    public Mono<Boolean> existsClientById(UUID clientId) {
        return clientRepository.existsById(clientId);
    }

    @Override
    public Mono<UUID> validateExistsClientById(UUID clientId) {
        return existsClientById(clientId)
                .filter(exists -> exists)
                .switchIfEmpty(Mono.error(new ClientNotFoundException(CLIENT_NOT_FOUND)))
                .thenReturn(clientId);
    }

    @Override
    public Mono<Boolean> existsClientByEmail(String clientEmail) {
        return clientRepository.existsClientByEmailIgnoreCase(clientEmail);
    }

    @Override
    public Mono<Void> validateExistsClientByEmail(String clientEmail) {
        return existsClientByEmail(clientEmail)
                .filter(exists -> !exists)
                .switchIfEmpty(Mono.error(new ClientEmailAlreadyExistsException(CLIENT_EMAIL_EXIST)))
                .then();
    }

    @Override
    public Mono<ClientApplicationDTO> validateClientApplicationDTO(ClientApplicationDTO clientAppDTO) {
        return Mono.just(clientAppDTO)
                .flatMap(clientApplicationDTO -> validateClientAppDTO(clientApplicationDTO)
                        .thenReturn(clientApplicationDTO)
                )
                .flatMap(clientApplicationDTO -> validateExistsClientByEmail(clientApplicationDTO.email())
                        .thenReturn(clientApplicationDTO)
                );
    }

    @SuppressWarnings("DataFlowIssue")
    @Override
    public Mono<Void> validateClientAppDTO(ClientApplicationDTO clientAppDTO) {
        clientAppValidator.validate(clientAppDTO, null);
        return Mono.empty();
    }

}
