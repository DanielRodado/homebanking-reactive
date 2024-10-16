package com.example.homebanking_reactive.services;

import com.example.homebanking_reactive.entities.CardEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface CardService {

    Flux<CardEntity> getCardsByClientId(UUID clientId);

    Mono<CardEntity> saveCard(CardEntity card);

}
