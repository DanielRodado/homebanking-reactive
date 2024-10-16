package com.example.homebanking_reactive.services.implement;

import com.example.homebanking_reactive.entities.CardEntity;
import com.example.homebanking_reactive.repositories.CardRepository;
import com.example.homebanking_reactive.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository cardRepository;

    @Override
    public Flux<CardEntity> getCardsByClientId(UUID clientId) {
        return cardRepository.findByClientId(clientId);
    }

    @Override
    public Mono<CardEntity> saveCard(CardEntity card) {
        return cardRepository.save(card);
    }
}
