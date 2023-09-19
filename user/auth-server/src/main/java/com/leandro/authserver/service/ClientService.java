package com.leandro.authserver.service;

import com.leandro.authserver.entity.Client;

public interface ClientService {

    Client findByRedirectUris(String uri);

}
