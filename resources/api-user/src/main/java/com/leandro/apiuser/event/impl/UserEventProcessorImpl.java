package com.leandro.apiuser.event.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.leandro.apiuser.event.EventData;
import com.leandro.apiuser.event.UserEventProcessor;
import com.leandro.apiuser.model.dto.event.CreateUserEvent;
import com.leandro.apiuser.model.entity.UserEvent;
import com.leandro.apiuser.repository.UserEventRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class UserEventProcessorImpl implements UserEventProcessor {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final UserEventRepository userEventRepository;

    @Override
    @Scheduled(fixedDelay = 10000)
    @Transactional
    public void send() {

        var transactionId = transactionEvents();
        var events = userEventRepository.findUpdatedUnprocessedEvents(transactionId);
        if (!events.isEmpty()) {
            kafkaTemplate.send("create-user", eventData(transactionId, events));
            userEventRepository.updateProcessedEventsWithTransactionId(transactionId, new Timestamp(new Date().getTime()));
        }
    }

    private String eventData(UUID transactionId, List<UserEvent> events) {
        var eventData = EventData.builder()
                .transactionId(transactionId)
                .data(toMessages(events))
                .build();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(eventData);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

    private UUID transactionEvents() {
        var transactionId = UUID.randomUUID();
        userEventRepository.updateUnprocessedEventsWithTransactionId(transactionId);
        return transactionId;
    }

    private List<CreateUserEvent> toMessages(List<UserEvent> events) {
        List<CreateUserEvent> messages = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        events.forEach(event -> {
            try {
                messages.add(objectMapper.readValue(event.getEventData(), CreateUserEvent.class));
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }

        });
        return messages;
    }

}
