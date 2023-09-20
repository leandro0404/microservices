package com.leandro.authserver.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.AuthorizationGrantType;

import java.util.*;

@Data
@Document(collection = "registered_clients")
public class Client {

    @Id
    private String id;

    private String clientId;
    private Set<String> resourceIds = Collections.emptySet();
    private boolean secretRequired;
    private String clientSecret;
    private boolean scoped;
    private Set<String> scope;
    private Set<String> authenticationMethods;
    private Set<AuthorizationGrantType> authorizedGrantTypes = Collections.emptySet();
    private Set<String> redirectUris = new HashSet<>();
    private Collection<GrantedAuthority> authorities;
    private Integer accessTokenValiditySeconds;
    private Integer refreshTokenValiditySeconds;
    private boolean autoApprove;
    private Map<String, Object> additionalInformation = new LinkedHashMap<>();

}
