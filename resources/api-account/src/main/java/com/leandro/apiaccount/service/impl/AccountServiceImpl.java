package com.leandro.apiaccount.service.impl;

import com.leandro.apiaccount.model.dto.event.CreateUserEvent;
import com.leandro.apiaccount.model.dto.response.AccountResponse;
import com.leandro.apiaccount.model.entity.Account;
import com.leandro.apiaccount.repository.AccountRepository;
import com.leandro.apiaccount.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    @Override
    public List<AccountResponse> findByUserId(UUID userId) {
        return accountRepository
                .findByUserId(userId)
                .stream()
                .map(this::toAccountResponse)
                .toList();
    }

    private AccountResponse toAccountResponse(Account account) {
        return new AccountResponse(account.getId(), account.getUserId());
    }

    @Override
    public void create(CreateUserEvent createUserEvent) {
        var account = new Account();
        account.setId(UUID.randomUUID());
        account.setUserId(createUserEvent.id());
        accountRepository.save(account);
    }
}
