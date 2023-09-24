package com.leandro.apiaccount.event;

import com.leandro.apiaccount.model.dto.event.CreateUserEvent;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Builder
@Data
@Getter
public class EventData {
    private UUID transactionId;
    private List<CreateUserEvent> data;
}
