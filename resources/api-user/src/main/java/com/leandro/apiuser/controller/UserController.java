package com.leandro.apiuser.controller;

import com.leandro.apiuser.model.dto.response.CreateUserRequest;
import com.leandro.apiuser.model.dto.response.UserResponse;
import com.leandro.apiuser.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("{username}")
    public ResponseEntity<UserResponse> get(@PathVariable String userName) {
        return ResponseEntity.ok(userService.get(userName));
    }

    @PostMapping
    public ResponseEntity post(@RequestBody CreateUserRequest request) {
        userService.create(request);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}