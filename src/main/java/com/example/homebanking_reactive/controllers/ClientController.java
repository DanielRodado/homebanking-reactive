package com.example.homebanking_reactive.controllers;

import com.example.homebanking_reactive.dto.clientDTO.ClientApplicationDTO;
import com.example.homebanking_reactive.dto.clientDTO.ClientDTO;
import com.example.homebanking_reactive.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/{clientId}")
    public Mono<ClientDTO> getClientById(@PathVariable String clientId){
        return clientService.getClientDTOById(clientId);
    }

    @GetMapping
    public Flux<ClientDTO> getClients(){
        return clientService.getClientsDTO();
    }

    @PostMapping
    public Mono<ResponseEntity<String>> createClient(@RequestBody ClientApplicationDTO clientAppDTO){
        return clientService
                .createClient(clientAppDTO)
                .thenReturn(ResponseEntity.status(201).body("Client created"));
    }

    @DeleteMapping("/{clientId}")
    public Mono<ResponseEntity<String>> deleteClient(@PathVariable String clientId){
        return clientService
                .deleteClient(clientId)
                .thenReturn(ResponseEntity.noContent().build());
    }

}
