package com.leandro.apia.controller;

import com.leandro.apia.dto.DemoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("home")
    public ResponseEntity<DemoResponse> get(@AuthenticationPrincipal Jwt jwt) {
        return ResponseEntity.ok(new DemoResponse("hello demo application", jwt.getClaims()));
    }
}
