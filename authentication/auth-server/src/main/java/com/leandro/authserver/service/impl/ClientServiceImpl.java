package com.leandro.authserver.service.impl;

import com.leandro.authserver.entity.Client;
import com.leandro.authserver.repository.ClientRepository;
import com.leandro.authserver.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client findByRedirectUris(String uri) {
        return clientRepository.findByRedirectUris(uri);
    }

    @Override
    public Client create(Client client) {
        String secret = passwordEncoder.encode(client.getClientSecret());
        client.setClientSecret(secret);
        return clientRepository.save(client);
    }
}
