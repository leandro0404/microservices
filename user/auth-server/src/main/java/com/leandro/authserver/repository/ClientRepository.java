package com.leandro.authserver.repository;

import com.leandro.authserver.entity.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface ClientRepository extends MongoRepository<Client, String> {

    Optional<Client> findByClientId(String clientId);

    @Query("{'redirectUris': { $regex: ?0, $options: 'i' }}")
    Client findByRedirectUris(String uri);
}