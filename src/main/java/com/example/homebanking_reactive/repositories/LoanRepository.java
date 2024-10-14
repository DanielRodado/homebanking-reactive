package com.example.homebanking_reactive.repositories;

import com.example.homebanking_reactive.models.LoanModel;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface LoanRepository extends ReactiveCrudRepository<LoanModel, UUID> {
}
