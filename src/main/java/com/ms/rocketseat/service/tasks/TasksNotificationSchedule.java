package com.ms.rocketseat.service.tasks;

import com.ms.rocketseat.service.tasks.services.TaskService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TasksNotificationSchedule {

    private final TaskService taskService;

    public TasksNotificationSchedule(TaskService taskService) {
        this.taskService = taskService;
    }

    @Scheduled(fixedRate = 60)
    public void checkAndNotifyTasks() {
        this.taskService.sendNotificationForDueTasks();
    }
}
