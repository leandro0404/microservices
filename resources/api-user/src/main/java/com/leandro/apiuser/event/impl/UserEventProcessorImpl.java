package com.leandro.apiuser.event.impl;

import com.leandro.apiuser.event.UserEventProcessor;
import com.leandro.apiuser.repository.UserEventRepository;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;

@Component
@AllArgsConstructor
public class UserEventProcessorImpl implements UserEventProcessor {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final UserEventRepository userEventRepository;

    @Override
    @Scheduled(fixedDelay = 10000)
    public void send() {
        var events = userEventRepository.findUnprocessedEvents();
        events.forEach(event -> {
            kafkaTemplate.send("create-user", event.getEventData());
            event.setProcessedOn(new Timestamp(new Date().getTime()));
            userEventRepository.save(event);
        });
    }
}
