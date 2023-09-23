package com.leandro.apiapplication.controller;

import com.leandro.apiapplication.model.dto.response.ApplicationResponse;
import com.leandro.apiapplication.model.dto.response.CreateApplicationRequest;
import com.leandro.apiapplication.service.ApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/application")
@AllArgsConstructor
public class ApplicationController {

    private final ApplicationService applicationService;

    @GetMapping
    public ResponseEntity<List<ApplicationResponse>> get() {
        return ResponseEntity.ok(applicationService.get());
    }

    @PostMapping
    public ResponseEntity post(@RequestBody CreateApplicationRequest request) {
        applicationService.create(request);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}