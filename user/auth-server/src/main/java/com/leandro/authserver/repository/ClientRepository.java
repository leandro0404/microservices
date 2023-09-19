package com.leandro.authserver.repository;

import com.leandro.authserver.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, String> {

    Optional<Client> findByClientId(String clientId);

    @Query("SELECT c FROM Client c WHERE c.redirectUris LIKE %:uri%")
    Client findByRedirectUris(String uri);
}