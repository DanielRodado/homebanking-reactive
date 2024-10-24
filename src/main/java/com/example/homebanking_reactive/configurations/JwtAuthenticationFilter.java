package com.example.homebanking_reactive.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Component
public class JwtAuthenticationFilter implements WebFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @SuppressWarnings("NullableProblems")
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        String authHeader = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        String uri = exchange.getRequest().getURI().toString();

        if (uri.contains("/api/auth/")) {
            return chain.filter(exchange);
        }

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            try {
                if (jwtUtil.validateToken(token)) {
                    if (checkAuthorization(token, exchange)) {
                        return unauthorized(exchange); // Not authorized to access this resource
                    } else {
                        String clientEmail = jwtUtil.extractUsername(token);
                        exchange.getRequest().mutate().header("email", clientEmail).build();
                    }
                } else {
                    return unauthorized(exchange); // JWT token invalid
                }
            } catch (Exception ignore) {
                return unauthorized(exchange); // JWT token validation failed
            }
        } else {
            return unauthorized(exchange); // Header missing or invalid
        }

        return chain.filter(exchange);
    }

    private Mono<Void> unauthorized(ServerWebExchange exchange) {
        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
        return exchange.getResponse().setComplete();
    }

    private boolean checkAuthorization(String token, ServerWebExchange exchange) {
        return jwtUtil.parseClaims(token).get("rol").equals("CLIENT") && !exchange.getRequest().getURI().toString().contains("current");
    }
}
