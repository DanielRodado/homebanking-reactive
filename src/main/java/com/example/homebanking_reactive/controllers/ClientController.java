package com.example.homebanking_reactive.controllers;

import com.example.homebanking_reactive.dto.clientDTO.ClientApplicationDTO;
import com.example.homebanking_reactive.dto.clientDTO.ClientDTO;
import com.example.homebanking_reactive.services.ClientAccountService;
import com.example.homebanking_reactive.services.ClientService;
import com.example.homebanking_reactive.utils.AuthUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.example.homebanking_reactive.utils.AuthUtil.getEmailAuthToHeader;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientAccountService clientAccountService;

    @GetMapping("/{clientId}")
    public Mono<ClientDTO> getClientById(@PathVariable String clientId){
        return clientService.getClientDTOById(clientId);
    }

    @GetMapping("/current")
    public Mono<ClientDTO> getClientCurrent(ServerWebExchange exchange){
        return getEmailAuthToHeader(exchange).flatMap(clientService::getClientDTOByEmail);
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

    /*@DeleteMapping("/{clientId}")
    public Mono<ResponseEntity<String>> deleteClient(@PathVariable String clientId){
        return clientService
                .deleteClient(clientId)
                .thenReturn(ResponseEntity.noContent().build());
    }*/

}
