package com.example.homebanking_reactive.services.implement;

import com.example.homebanking_reactive.dto.clientDTO.ClientDTO;
import com.example.homebanking_reactive.dto.loanDTO.ClientLoanDTO;
import com.example.homebanking_reactive.models.ClientLoanModel;
import com.example.homebanking_reactive.repositories.ClientLoanRepository;
import com.example.homebanking_reactive.services.ClientLoanService;
import com.example.homebanking_reactive.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashSet;
import java.util.List;
import java.util.UUID;

@Service
public class ClientLoanServiceImpl implements ClientLoanService {

    @Autowired
    private ClientLoanRepository clientLoanRepository;

    @Autowired
    private LoanService loanService;

    @Override
    public Flux<ClientLoanModel> getClientLoansByClientId(UUID clientId) {
        return clientLoanRepository.findByClientId(clientId);
    }

    @Override
    public Mono<List<ClientLoanDTO>> getClientLoansDTOByClientId(UUID clientId) {
        return getClientLoansByClientId(clientId)
                .flatMap(clientLoanModel -> loanService
                        .getNameOfLoanById(clientLoanModel.getLoanId())
                        .map(loanName -> new ClientLoanDTO(clientLoanModel, loanName))
                )
                .collectList();
    }

    @Override
    public Mono<ClientDTO> getClientLoansFromClient(ClientDTO clientDTO) {
        return getClientLoansDTOByClientId(clientDTO.getId())
                .flatMap(clientLoanDTOS -> {
                    clientDTO.setLoans(new HashSet<>(clientLoanDTOS));
                    return Mono.just(clientDTO);
                });
    }

    @Override
    public Mono<ClientLoanModel> saveClientLoan(ClientLoanModel clientLoan) {
        return clientLoanRepository.save(clientLoan);
    }
}
