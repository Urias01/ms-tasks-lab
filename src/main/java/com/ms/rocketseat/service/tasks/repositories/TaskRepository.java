package com.ms.rocketseat.service.tasks.repositories;

import com.ms.rocketseat.service.tasks.entities.TasksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TasksEntity, Long> {

    @Query(value = "SELECT t FROM Task t WHERE t.dueDate <= :deadline AND t.notified = false")
    List<TasksEntity> findTasksDueWithinDeadline(LocalDateTime deadline);
}
