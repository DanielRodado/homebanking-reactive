package com.example.homebanking_reactive.builders;

import com.example.homebanking_reactive.enums.RoleType;
import com.example.homebanking_reactive.models.ClientEntity;

public class ClientBuilder {

    private ClientEntity client;

    public ClientBuilder name(String name) {
        client.setName(name);
        return this;
    }

    public ClientBuilder lastName(String lastName) {
        client.setLastName(lastName);
        return this;
    }

    public ClientBuilder email(String email) {
        client.setEmail(email);
        return this;
    }

    public ClientBuilder password(String password) {
        client.setPassword(password);
        return this;
    }

    public ClientBuilder role(RoleType role) {
        client.setRole(role);
        return this;
    }

    public ClientEntity build() {
        return client;
    }

}