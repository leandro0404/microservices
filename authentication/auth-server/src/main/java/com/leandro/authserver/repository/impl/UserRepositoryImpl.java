package com.leandro.authserver.repository.impl;

import com.leandro.authserver.entity.User;
import com.leandro.authserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Override
    public User findByUsername(String username) {

            var webClient = WebClient.builder()
                    .baseUrl("http://localhost:9006")
                    .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .defaultHeader(HttpHeaders.AUTHORIZATION,  token())
                    .build();

            var request = webClient.get()
                    .uri("/user/" + username)
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(User.class);

            return request.block();


    }


    @Override
    public void create(User user) {

        var token = "";

        var webClient = WebClient.builder()
                .baseUrl("http://localhost:9006")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.AUTHORIZATION,  token())
                .build();

        webClient.post()
                .uri("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(user), User.class)
                .retrieve()
                .bodyToMono(String.class)
                .subscribe(response -> {
                    // Lide com a resposta da chamada POST aqui
                });

    }
    private String token()
    {
        var client = WebClient.builder()
                .baseUrl("http://localhost:9002/oauth2/token")
                .defaultHeader("Content-Type", "application/x-www-form-urlencoded")
                .defaultHeader("Authorization", "Basic Y2xpZW50LWNyZWRlbnRpYWxzOnNlY3JldA==")
                .build();
        //   .post(). ()

        var tokenResponse = client.post()
                .header(HttpHeaders.AUTHORIZATION, "Basic Y2xpZW50LWNyZWRlbnRpYWxzOnNlY3JldA==")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(BodyInserters.fromFormData("grant_type", "client_credentials"))
                .retrieve()
                .bodyToMono(TokenResponse.class)
                .block();

       return "bearer " + tokenResponse.access_token;
    }

    public record TokenResponse (String access_token,
            String token_type,
            int expires_in){


    }
}

