package com.example.homebanking_reactive.dto.cardDTO;

import com.example.homebanking_reactive.entities.CardEntity;
import com.example.homebanking_reactive.enums.CardColorType;
import com.example.homebanking_reactive.enums.CardType;

import java.time.LocalDate;
import java.util.UUID;

public class CardDTO {

    private final UUID id;
    private final String cardHolder, number, cvv;
    private final LocalDate fromDate, thruDate;
    private final CardColorType cardColor;
    private final CardType cardType;

    public CardDTO(CardEntity card) {
        id = card.getId();
        cardHolder = card.getCardHolder();
        number = card.getNumber();
        cvv = card.getCvv();
        fromDate = card.getFromDate();
        thruDate = card.getThruDate();
        cardColor = card.getCardColor();
        cardType = card.getCardType();
    }

    public UUID getId() {
        return id;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public String getNumber() {
        return number;
    }

    public String getCvv() {
        return cvv;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public LocalDate getThruDate() {
        return thruDate;
    }

    public CardColorType getColor() {
        return cardColor;
    }

    public CardType getType() {
        return cardType;
    }
}
