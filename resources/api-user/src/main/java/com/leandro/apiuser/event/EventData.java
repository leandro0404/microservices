package com.leandro.apiuser.event;

import com.leandro.apiuser.model.dto.event.CreateUserEvent;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Builder
@Data
public class EventData {
    private UUID transactionId;
    private List<CreateUserEvent> data;
}
