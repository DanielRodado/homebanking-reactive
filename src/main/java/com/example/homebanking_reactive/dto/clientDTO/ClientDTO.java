package com.example.homebanking_reactive.dto.clientDTO;

import com.example.homebanking_reactive.dto.accountDTO.AccountDTO;
import com.example.homebanking_reactive.dto.cardDTO.CardDTO;
import com.example.homebanking_reactive.dto.loanDTO.ClientLoanDTO;
import com.example.homebanking_reactive.enums.RoleType;
import com.example.homebanking_reactive.entities.ClientEntity;

import java.util.Set;
import java.util.UUID;

public class ClientDTO {

    private final UUID id;

    private final String name, lastName, email;

    private final RoleType role;

    private Set<AccountDTO> accounts;

    private Set<CardDTO> cards;

    private Set<ClientLoanDTO> loans;

    public ClientDTO(ClientEntity client) {
        id = client.getId();
        name = client.getName();
        lastName = client.getLastName();
        email = client.getEmail();
        role = client.getRole();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public RoleType getRole() {
        return role;
    }

    public Set<AccountDTO> getAccounts() {
        return accounts;
    }

    public void setAccountDTOS(Set<AccountDTO> accountDTOS) {
        this.accounts = accountDTOS;
    }

    public Set<CardDTO> getCards() {
        return cards;
    }

    public void setCards(Set<CardDTO> cards) {
        this.cards = cards;
    }

    public Set<ClientLoanDTO> getLoans() {
        return loans;
    }

    public void setLoans(Set<ClientLoanDTO> loanDTOS) {
        this.loans = loanDTOS;
    }
}
