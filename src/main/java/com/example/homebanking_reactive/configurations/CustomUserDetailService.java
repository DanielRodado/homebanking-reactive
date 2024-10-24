package com.example.homebanking_reactive.configurations;

import com.example.homebanking_reactive.exceptions.clientExceptions.ClientNotFoundException;
import com.example.homebanking_reactive.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import static com.example.homebanking_reactive.utils.AuthMessageUtil.CLIENT_NOT_FOUND_AUTH;

@Service
public class CustomUserDetailService implements ReactiveUserDetailsService {

    @Autowired
    private ClientService clientService;

    @Override
    public Mono<UserDetails> findByUsername(String username) {
        return clientService.getClientByEmail(username)
                .switchIfEmpty(Mono.error(new ClientNotFoundException(CLIENT_NOT_FOUND_AUTH + username)))
                .map(client -> new User(client.getEmail(), client.getPassword(), AuthorityUtils.createAuthorityList(client.getRole().toString())));
    }
}
