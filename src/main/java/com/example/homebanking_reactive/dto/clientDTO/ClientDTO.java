package com.example.homebanking_reactive.dto.clientDTO;

import com.example.homebanking_reactive.enums.RoleType;
import com.example.homebanking_reactive.models.ClientModel;

import java.util.UUID;

public class ClientDTO {

    private final UUID id;

    private final String name, lastName, email;

    private final RoleType role;

    public ClientDTO(ClientModel client) {
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
}
