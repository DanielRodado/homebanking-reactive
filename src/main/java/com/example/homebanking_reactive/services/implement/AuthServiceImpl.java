package com.example.homebanking_reactive.services.implement;

import com.example.homebanking_reactive.configurations.JwtUtil;
import com.example.homebanking_reactive.dto.clientDTO.ClientApplicationDTO;
import com.example.homebanking_reactive.dto.clientDTO.LoginClient;
import com.example.homebanking_reactive.services.AuthService;
import com.example.homebanking_reactive.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import static com.example.homebanking_reactive.utils.AuthUtil.getFirstAuthority;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ReactiveAuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public Mono<Void> registerClient(ClientApplicationDTO clientApp) {
        return clientService.createClient(clientApp);
    }

    @Override
    public Mono<ResponseEntity<String>> login(LoginClient loginClient) {
        return generateCurrentClient(loginClient)
                .flatMap(this::getUserDetails)
                .flatMap(userDetails -> generateJwtToken(userDetails.getUsername(), getFirstAuthority(userDetails))
                .map(token -> ResponseEntity.ok().body(token))
                .onErrorResume(err -> Mono.just(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build())));
    }

    @Override
    public Mono<Authentication> generateCurrentClient(LoginClient loginClient) {
        return authenticationManager.authenticate(authenticateClient(loginClient));
    }

    @Override
    public UsernamePasswordAuthenticationToken authenticateClient(LoginClient loginClient) {
        return new UsernamePasswordAuthenticationToken(loginClient.email(), loginClient.password());
    }

    @Override
    public Mono<UserDetails> getUserDetails(Authentication authentication) {
        return Mono.just((UserDetails) authentication.getPrincipal());
    }

    @Override
    public Mono<String> generateJwtToken(String username, String rol) {
        return Mono.just(jwtUtil.generateToken(username, rol));
    }

}
