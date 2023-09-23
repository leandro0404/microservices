package com.leandro.apiapplication.repository;


import com.leandro.apiapplication.model.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ApplicationRepository extends JpaRepository<Application, UUID> {
}
