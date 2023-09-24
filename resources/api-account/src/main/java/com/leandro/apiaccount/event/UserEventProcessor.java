package com.leandro.apiaccount.event;

import org.springframework.kafka.support.Acknowledgment;

public interface UserEventProcessor {
   void listenCreateUser(String message);
}
