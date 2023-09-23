package com.leandro.apiuser.model.dto.response;

import java.util.UUID;

public record UserResponse(UUID id, String username, String password) {
}
