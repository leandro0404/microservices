package com.leandro.apiuser.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User {

    @Id
    private UUID id;
    private String userName;
    private String password;
    @Column(name = "active", columnDefinition = "boolean default true")
    private boolean active;
    @Column(name = "created", columnDefinition = "timestamp default current_timestamp")
    private Timestamp created;
    private Timestamp updated;

}