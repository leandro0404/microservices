package com.leandro.apiapplication.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "application")
@Getter
@Setter
public class Application {

    @Id
    private UUID id;
    private String name;
    private String description;
    @Column(name = "active", columnDefinition = "boolean default true")
    private boolean active;
    @Column(name = "created", columnDefinition = "timestamp default current_timestamp")
    private Timestamp created;
    private Timestamp updated;

}