package com.example.homebanking_reactive.validations.services;

import com.example.homebanking_reactive.dto.clientDTO.ClientApplicationDTO;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface ClientServiceValidation {

    Mono<UUID> validateClientId(String clientId);

    Mono<Boolean> existsClientById(UUID clientId);

    Mono<UUID> validateExistsClientById(UUID clientId);

    Mono<Boolean> existsClientByEmail(String clientEmail);

    Mono<Void> validateExistsClientByEmail(String clientEmail);

    Mono<ClientApplicationDTO> validateClientApplicationDTO(ClientApplicationDTO clientAppDTO);

    Mono<Void> validateClientAppDTO(ClientApplicationDTO clientAppDTO);

}
