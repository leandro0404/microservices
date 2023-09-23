package com.leandro.apiuser.service.impl;


import com.leandro.apiuser.model.dto.response.CreateUserRequest;
import com.leandro.apiuser.model.dto.response.UserResponse;
import com.leandro.apiuser.model.entity.User;
import com.leandro.apiuser.repository.UserRepository;
import com.leandro.apiuser.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponse get(String userName) {
        return toObject(userRepository.findByUserName(userName));


    }

    @Override
    public void create(CreateUserRequest request) {
        userRepository.save(toObject(request));
    }

    private User toObject(CreateUserRequest request) {
        var user = new User();
        user.setId(UUID.randomUUID());
        user.setUserName(request.username());
        user.setPassword(request.password());
        return user;
    }

    private UserResponse toObject(User user) {

        return new UserResponse(user.getId(), user.getUserName(),user.getPassword());
    }
}
