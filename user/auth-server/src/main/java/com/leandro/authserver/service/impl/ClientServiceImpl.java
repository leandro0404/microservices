package com.leandro.authserver.service.impl;

import com.leandro.authserver.entity.Client;
import com.leandro.authserver.repository.ClientRepository;
import com.leandro.authserver.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl  implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client findByRedirectUris(String uri) {
        return clientRepository.findByRedirectUris(uri);
    }
}
