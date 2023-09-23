package com.leandro.apiuser.event;

import com.leandro.apiuser.model.dto.event.CreateUserEvent;

public interface UserEventProcessor {
    void send();
}
