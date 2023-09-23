package com.leandro.authserver.repository;

import com.leandro.authserver.entity.User;

public interface UserRepository  {
    User findByUsername(String username);
    void create (User user);
}