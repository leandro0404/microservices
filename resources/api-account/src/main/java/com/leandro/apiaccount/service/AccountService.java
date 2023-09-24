package com.leandro.apiaccount.service;

import com.leandro.apiaccount.model.dto.event.CreateUserEvent;
import com.leandro.apiaccount.model.dto.response.AccountResponse;

import java.util.List;
import java.util.UUID;

public interface AccountService {
    List<AccountResponse> findByUserId(UUID userId);

    void create(CreateUserEvent createUserEvent);
}
