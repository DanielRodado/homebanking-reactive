package com.example.homebanking_reactive.validations.services.implement;

import com.example.homebanking_reactive.dto.ClientApplicationDTO;
import com.example.homebanking_reactive.exceptions.ClientEmailAlreadyExistsException;
import com.example.homebanking_reactive.repositories.ClientRepository;
import com.example.homebanking_reactive.validations.ClientAppValidator;
import com.example.homebanking_reactive.validations.services.ClientServiceValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import static com.example.homebanking_reactive.utils.MessageUtil.CLIENT_EMAIL_EXIST;

@Service
public class ClientServiceValidationImpl implements ClientServiceValidation {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientAppValidator clientAppValidator;

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
