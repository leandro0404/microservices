package com.leandro.apiuser.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(unique = true)
    private String username;
    private String password;
    @Column(name = "active", columnDefinition = "boolean default true")
    private boolean active;
    @Column(name = "created", columnDefinition = "timestamp default current_timestamp")
    private Timestamp created;
    private Timestamp updated;

}