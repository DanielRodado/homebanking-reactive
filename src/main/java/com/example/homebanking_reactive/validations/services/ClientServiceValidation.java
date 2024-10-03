package com.example.homebanking_reactive.validations.services;

import com.example.homebanking_reactive.dto.ClientApplicationDTO;
import reactor.core.publisher.Mono;

public interface ClientServiceValidation {

    Mono<Boolean> existsClientByEmail(String clientEmail);

    Mono<Void> validateExistsClientByEmail(String clientEmail);

    Mono<ClientApplicationDTO> validateClientApplicationDTO(ClientApplicationDTO clientAppDTO);

    Mono<Void> validateClientAppDTO(ClientApplicationDTO clientAppDTO);

}
