package com.leandro.authserver.service.impl;

import com.leandro.authserver.repository.impl.JpaRegisteredClientRepository;
import com.leandro.authserver.service.ClientService;
import com.leandro.authserver.service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private JpaRegisteredClientRepository jpaRegisteredClientRepository;
    @Autowired
    private ClientService clientService;

    @Override
    public String layout(HttpServletRequest request, Model model) {
        var client = clientService.findByRedirectUris(request.getHeader("Referer"));

        if (client != null && client.getClientId().equals("app-site-b")) {
            model.addAttribute("name", client.getClientName());
            model.addAttribute("clientId", client.getClientId());
            return client.getClientId();
        }

        return "login";
    }
}
