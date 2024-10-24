package com.example.homebanking_reactive.controllers;

import com.example.homebanking_reactive.dto.clientDTO.ClientApplicationDTO;
import com.example.homebanking_reactive.dto.clientDTO.LoginClient;
import com.example.homebanking_reactive.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import static com.example.homebanking_reactive.utils.AuthMessageUtil.REGISTERED;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public Mono<ResponseEntity<String>> login(@RequestBody LoginClient loginClient) {
        return authService.login(loginClient);
    }

    @PostMapping("/register")
    public Mono<ResponseEntity<String>> register(@RequestBody ClientApplicationDTO clientApp) {
        return authService.registerClient(clientApp).thenReturn(ResponseEntity.status(201).body(REGISTERED));
    }

}
