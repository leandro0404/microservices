package com.leandro.apiuser.model.dto.response;

public record CreateUserRequest(String username, String email, String password) {
}
