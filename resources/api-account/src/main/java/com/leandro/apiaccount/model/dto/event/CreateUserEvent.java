package com.leandro.apiaccount.model.dto.event;

import java.util.UUID;
public record CreateUserEvent(UUID id, String username, String email) {

}