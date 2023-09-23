package com.leandro.apiapplication.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "user_application", uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "application_id"}))
@Getter
@Setter
public class UserApplication {
    @Id
    private UUID id;
    @Column(name = "user_id")
    private UUID userId;
    @Column(name = "application_id")
    private UUID applicationId;
    @Column(name = "active", columnDefinition = "boolean default true")
    private boolean active;
    @Column(name = "created", columnDefinition = "timestamp default current_timestamp")
    private Timestamp created;
    @Column(name = "lastAccess")
    private Timestamp lastAccess;
}
