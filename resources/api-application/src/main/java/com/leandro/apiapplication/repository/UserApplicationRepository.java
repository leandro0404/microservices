package com.leandro.apiapplication.repository;

import com.leandro.apiapplication.model.entity.UserApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserApplicationRepository  extends JpaRepository<UserApplication, UUID> {
}
