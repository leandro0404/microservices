package com.leandro.apiuser.repository;

import com.leandro.apiuser.model.entity.UserEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

public interface UserEventRepository extends JpaRepository<UserEvent, UUID> {

    @Modifying
    @Query("UPDATE UserEvent e SET e.transactionId = :transactionId WHERE e.transactionId IS NULL AND e.processedOn IS NULL")
    void updateUnprocessedEventsWithTransactionId(@Param(value = "transactionId") UUID transactionId);

    @Modifying
    @Query("UPDATE UserEvent e SET e.processedOn = :processedOn WHERE e.transactionId = :transactionId ")
    void updateProcessedEventsWithTransactionId(@Param(value = "transactionId") UUID transactionId, @Param(value = "processedOn") Timestamp processedOn);

    @Query("SELECT e FROM UserEvent e WHERE e.processedOn IS NULL AND e.transactionId = :transactionId")
    List<UserEvent> findUpdatedUnprocessedEvents(UUID transactionId);
}
