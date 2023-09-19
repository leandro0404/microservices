//package com.leandro.authserver.config.client;
//
//import java.util.UUID;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.oauth2.core.AuthorizationGrantType;
//import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
//import org.springframework.security.oauth2.core.oidc.OidcScopes;
//import org.springframework.security.oauth2.server.authorization.client.InMemoryRegisteredClientRepository;
//import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
//import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
//import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;
//
//@Configuration
//public class ClientStoreConfig {
//
//  @Bean
//  RegisteredClientRepository registeredClientRepository() {
//
//    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//
//    RegisteredClient registeredClient = RegisteredClient.withId(UUID.randomUUID().toString())
//        .clientId("client-server")
//        .clientSecret(passwordEncoder.encode( "secret"))
//        .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
//        .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
//        .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
//        .redirectUri("http://localhost:9003/login/oauth2/code/client-server-oidc")
//        .scope(OidcScopes.OPENID)
//        .scope(OidcScopes.PROFILE)
//        .clientSettings(ClientSettings.builder()
//            .requireAuthorizationConsent(true).build())
//        .build();
//
//    RegisteredClient react = RegisteredClient.withId(UUID.randomUUID().toString())
//            .clientId("app-site-b")
//            .clientSecret(passwordEncoder.encode( "secret-b"))
//            .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
//            .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
//            .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
//            .redirectUri("http://localhost:3000/authorized")
//            .scope(OidcScopes.OPENID)
//            .scope(OidcScopes.PROFILE)
//            .clientSettings(ClientSettings.builder()
//                    .requireAuthorizationConsent(true)
//                    .build())
//            .build();
//
//    return new InMemoryRegisteredClientRepository(registeredClient,react);
//  }
//}
