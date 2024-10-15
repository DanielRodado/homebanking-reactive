package com.example.homebanking_reactive.entities;

import com.example.homebanking_reactive.enums.CardColorType;
import com.example.homebanking_reactive.enums.CardType;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.UUID;

@Table("cards")
public class CardEntity {

    @Id
    private UUID id;

    private String cardHolder, number, cvv;
    private LocalDate fromDate, thruDate;

    @Column("color")
    private CardColorType cardColor;

    @Column("type")
    private CardType cardType;

    private UUID clientId;

    public CardEntity() {
    }

    public CardEntity(CardBuilder cardBuilder) {
        cardHolder = cardBuilder.cardHolder;
        number = cardBuilder.number;
        cvv = cardBuilder.cvv;
        fromDate = LocalDate.now();
        thruDate = LocalDate.now().plusYears(5);
        cardColor = cardBuilder.cardColor;
        cardType = cardBuilder.cardType;
    }

    public static CardBuilder builder() {
        return new CardBuilder();
    }

    public static class CardBuilder {

        private String cardHolder, number, cvv;
        private CardColorType cardColor;
        private CardType cardType;

        public CardBuilder cardHolder(String cardHolder) {
            this.cardHolder = cardHolder;
            return this;
        }

        public CardBuilder number(String number) {
            this.number = number;
            return this;
        }

        public CardBuilder cvv(String cvv) {
            this.cvv = cvv;
            return this;
        }

        public CardBuilder colorType(CardColorType colorType) {
            this.cardColor = colorType;
            return this;
        }

        public CardBuilder cardType(CardType cardType) {
            this.cardType = cardType;
            return this;
        }

        public CardEntity build() {
            return new CardEntity(this);
        }
    }

    public UUID getId() {
        return id;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
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

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getThruDate() {
        return thruDate;
    }

    public void setThruDate(LocalDate thruDate) {
        this.thruDate = thruDate;
    }

    public CardColorType getCardColor() {
        return cardColor;
    }

    public void setCardColor(CardColorType cardColor) {
        this.cardColor = cardColor;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public UUID getClientId() {
        return clientId;
    }

    public void addClient(UUID clientId) {
        this.clientId = clientId;
    }
}
