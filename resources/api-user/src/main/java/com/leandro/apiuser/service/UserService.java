package com.leandro.apiuser.service;

import com.leandro.apiuser.model.dto.response.CreateUserRequest;
import com.leandro.apiuser.model.dto.response.UserResponse;

public interface UserService {

    UserResponse get (String username);
    void create(CreateUserRequest request);
}
