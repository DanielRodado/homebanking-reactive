package com.example.homebanking_reactive.services.implement;

import com.example.homebanking_reactive.dto.cardDTO.CardDTO;
import com.example.homebanking_reactive.dto.clientDTO.ClientDTO;
import com.example.homebanking_reactive.services.CardService;
import com.example.homebanking_reactive.services.ClientCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.HashSet;
import java.util.List;
import java.util.UUID;

@Service
public class ClientCardServiceImpl implements ClientCardService {

    @Autowired
    private CardService cardService;

    @Override
    public Mono<List<CardDTO>> getCardsDTOByClientId(UUID clientId) {
        return cardService.getCardsByClientId(clientId).map(CardDTO::new).collectList();
    }

    @Override
    public Mono<ClientDTO> getCardsFromClient(ClientDTO clientDTO) {
        return getCardsDTOByClientId(clientDTO.getId())
                .flatMap(cardDTOS -> {
                    clientDTO.setCards(new HashSet<>(cardDTOS));
                    return Mono.just(clientDTO);
                });
    }
}
