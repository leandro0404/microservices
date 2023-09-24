package com.leandro.apiaccount.controller;

import com.leandro.apiaccount.model.dto.response.AccountResponse;
import com.leandro.apiaccount.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/account")
@AllArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("{userId}")
    public ResponseEntity<List<AccountResponse>> get(@PathVariable UUID userId) {
        return ResponseEntity.ok(accountService.findByUserId(userId));
    }
}
