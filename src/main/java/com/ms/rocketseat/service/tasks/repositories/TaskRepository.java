package com.ms.rocketseat.service.tasks.repositories;

import com.ms.rocketseat.service.tasks.entities.TasksEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TasksEntity, Long> {
}
