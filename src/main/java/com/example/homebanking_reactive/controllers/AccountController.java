package com.example.homebanking_reactive.controllers;

import com.example.homebanking_reactive.dto.accountDTO.AccountDTO;
import com.example.homebanking_reactive.services.AccountService;
import com.example.homebanking_reactive.services.ClientAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.example.homebanking_reactive.utils.AccountMessageUtil.ACCOUNT_CREATED;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private ClientAccountService clientAccountService;

    @GetMapping("/{accountId}")
    public Mono<AccountDTO> getAccountDTOById(@PathVariable String accountId) {
        return accountService.getAccountDTOById(accountId);
    }

    @GetMapping
    public Flux<AccountDTO> getAccountsDTO() {
        return accountService.getAccountsDTO();
    }

    @PostMapping("/client/{clientId}")
    public Mono<ResponseEntity<String>> createAccount(@RequestBody String accountType, @PathVariable String clientId) {
        return clientAccountService
                .createAccount(accountType, clientId)
                .thenReturn(ResponseEntity.status(201).body(ACCOUNT_CREATED));
    }

}
