package com.leandro.apiaccount.model.dto.response;

import java.util.UUID;

public record AccountResponse (UUID id, UUID userId) {
}
