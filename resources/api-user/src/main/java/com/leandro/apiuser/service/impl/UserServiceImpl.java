package com.leandro.apiuser.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.leandro.apiuser.model.dto.event.CreateUserEvent;
import com.leandro.apiuser.model.dto.response.CreateUserRequest;
import com.leandro.apiuser.model.dto.response.UserResponse;
import com.leandro.apiuser.model.entity.User;
import com.leandro.apiuser.model.entity.UserEvent;
import com.leandro.apiuser.repository.UserEventRepository;
import com.leandro.apiuser.repository.UserRepository;
import com.leandro.apiuser.service.UserService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserEventRepository userEventRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponse get(String username) {
        return toObject(userRepository.findByUsername(username));

    }

    @Override
    @Transactional
    public void create(CreateUserRequest request) {
        var user = userRepository.save(toObject(request));
        userEventRepository.save(toCreateEventObject(request, user));

    }

    private User toObject(CreateUserRequest request) {
        var user = new User();
        user.setId(UUID.randomUUID());
        user.setUsername(request.username());
        user.setPassword(passwordEncoder.encode(request.password()));
        return user;
    }

    private UserEvent toCreateEventObject(CreateUserRequest request, User user) {
        try {
            var userEvent = new UserEvent();
            userEvent.setId(UUID.randomUUID());
            userEvent.setUserId(user.getId());
            userEvent.setEventType("create_user");
            var event = new CreateUserEvent(user.getId(), request.username(), request.email());
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(event);
            userEvent.setEventData(json);
            userEvent.setOccurredOn(new Timestamp(new Date().getTime()));
            return userEvent;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private UserResponse toObject(User user) {

        return new UserResponse(user.getId(), user.getUsername(), user.getPassword());
    }
}
