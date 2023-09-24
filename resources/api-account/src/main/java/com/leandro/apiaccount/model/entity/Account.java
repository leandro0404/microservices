package com.leandro.apiaccount.model.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "account")
@Getter
@Setter
public class Account {

    @Id
    private UUID id;
    @Column(name = "user_id")
    private UUID userId;
    @Column(name = "active", columnDefinition = "boolean default true")
    private boolean active;
    @Column(name = "created", columnDefinition = "timestamp default current_timestamp")
    private Timestamp created;

}