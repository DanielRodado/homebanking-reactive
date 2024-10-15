package com.example.homebanking_reactive.repositories;

import com.example.homebanking_reactive.entities.CardEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface CardRepository extends ReactiveCrudRepository<CardEntity, UUID> {
}
