package com.example.homebanking_reactive.services;

import com.example.homebanking_reactive.dto.cardDTO.CardDTO;
import com.example.homebanking_reactive.dto.clientDTO.ClientDTO;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

public interface ClientCardService {

    Mono<List<CardDTO>> getCardsDTOByClientId(UUID clientId);

    Mono<ClientDTO> getCardsFromClient(ClientDTO clientDTO);

}
