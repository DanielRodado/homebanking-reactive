package com.example.homebanking_reactive.models;

import com.example.homebanking_reactive.enums.RoleType;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Table("clients")
public class ClientEntity {

    @Id
    private UUID id;

    private String name, lastName, email, password;

    private RoleType role;

    public ClientEntity() {
    }

    private ClientEntity(ClientBuilder builder) {
        this.name = builder.name;
        this.lastName = builder.lastName;
        this.role = builder.role != null ? builder.role : RoleType.CLIENT;
        this.email = builder.email;
        this.password = builder.password;
    }

    public static ClientBuilder builder() {
        return new ClientBuilder();
    }

    public static class ClientBuilder {

        private String name, lastName, email, password;

        private RoleType role;

        public ClientBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ClientBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public ClientBuilder email(String email) {
            this.email = email;
            return this;
        }

        public ClientBuilder password(String password) {
            this.password = password;
            return this;
        }

        public ClientBuilder role(RoleType role) {
            this.role = role;
            return this;
        }

        public ClientEntity build() {
            return new ClientEntity(this);
        }
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleType getRole() {
        return role;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
