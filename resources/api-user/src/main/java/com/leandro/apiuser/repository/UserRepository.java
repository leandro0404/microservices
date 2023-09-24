package com.leandro.apiuser.repository;


import com.leandro.apiuser.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

     User findByUsername(String username);
}
