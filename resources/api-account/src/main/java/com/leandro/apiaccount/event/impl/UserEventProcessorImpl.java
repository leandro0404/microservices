package com.leandro.apiaccount.event.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.leandro.apiaccount.event.UserEventProcessor;
import com.leandro.apiaccount.model.dto.event.CreateUserEvent;
import com.leandro.apiaccount.service.AccountService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserEventProcessorImpl implements UserEventProcessor {

    private final AccountService accountService;
    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    @KafkaListener(topics = "create-user")
    @Transactional
    public void listenCreateUser(String message) {
        try {
            System.out.println(message);
            accountService.create(toCreateUserEvent(message));
        } catch (Exception ex) {
            kafkaTemplate.send("create-user-error", message);
        }
    }

    private CreateUserEvent toCreateUserEvent(String message) {
        try {
            return objectMapper.readValue(message, CreateUserEvent.class);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
