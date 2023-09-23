package com.leandro.apiuser.repository;

import com.leandro.apiuser.model.entity.UserEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface UserEventRepository  extends JpaRepository<UserEvent, UUID> {
    @Query("SELECT e FROM UserEvent e WHERE e.processedOn IS NULL")
    List<UserEvent> findUnprocessedEvents();
}
