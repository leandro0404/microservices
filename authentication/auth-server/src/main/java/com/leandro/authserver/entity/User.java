package com.leandro.authserver.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Document(collection = "user")
public class User {

    private String id;
    private String username;
    private String email;
    private String password;
    private Set<Authority> authorities = Set.of();
    private Boolean accountNonExpired = true;
    private Boolean accountNonLocked = true;
    private Boolean credentialsNonExpired = true;
    private Boolean enabled = true;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private LocalDate birthdate;
}