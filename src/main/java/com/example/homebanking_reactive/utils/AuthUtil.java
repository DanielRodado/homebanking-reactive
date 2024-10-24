package com.example.homebanking_reactive.utils;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

public final class AuthUtil {

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    public static String getFirstAuthority(UserDetails userDetails) {
        return userDetails.getAuthorities().stream()
                .findFirst()
                .get()
                .toString();
    }

    public static Mono<String> getEmailAuthToHeader(ServerWebExchange exchange) {
        return Mono.just(exchange.getRequest().getHeaders().getFirst("email"));
    }

}
