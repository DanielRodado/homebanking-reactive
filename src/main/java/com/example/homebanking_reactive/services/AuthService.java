package com.example.homebanking_reactive.services;

import com.example.homebanking_reactive.dto.clientDTO.ClientApplicationDTO;
import com.example.homebanking_reactive.dto.clientDTO.LoginClient;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import reactor.core.publisher.Mono;

public interface AuthService {

    Mono<Void> registerClient(ClientApplicationDTO clientApp);

    Mono<ResponseEntity<String>> login(LoginClient loginClient);

    Mono<Authentication> generateCurrentClient(LoginClient loginClient);

    UsernamePasswordAuthenticationToken authenticateClient(LoginClient loginClient);

    Mono<UserDetails> getUserDetails(Authentication authentication);

    Mono<String> generateJwtToken(String username, String rol);

}
