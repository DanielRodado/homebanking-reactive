package com.example.homebanking_reactive.repositories;

import com.example.homebanking_reactive.models.ClientEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ClientRepository extends ReactiveCrudRepository<ClientEntity, String> {
}
