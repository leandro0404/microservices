package com.leandro.authserver.service;

import com.leandro.authserver.entity.Client;

import java.util.List;

public interface ClientService {

    List<Client> findAll();
    Client findByRedirectUris(String uri);
    Client create(Client client);

}
