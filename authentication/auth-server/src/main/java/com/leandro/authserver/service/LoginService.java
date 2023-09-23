package com.leandro.authserver.service;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public interface LoginService {
    String layout(HttpServletRequest request, Model model);
}
