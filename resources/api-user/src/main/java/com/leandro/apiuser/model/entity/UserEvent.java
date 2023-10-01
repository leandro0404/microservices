package com.leandro.apiuser.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
import java.sql.Timestamp;

@Entity
@Table(name = "user-events")
@Getter
@Setter
public class UserEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "event_type")
    private String eventType;

    @Column(name = "event_data", columnDefinition = "TEXT")
    private String eventData;

    @Column(name = "occurred_on", columnDefinition = "timestamp default current_timestamp")
    private Timestamp occurredOn;

    @Column(name = "processed_on")
    private Timestamp processedOn;

    @Column(name = "transaction_id")
    private UUID transactionId;

}
