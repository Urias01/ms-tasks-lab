package com.ms.rocketseat.service.tasks.services;

import com.ms.rocketseat.service.tasks.entities.TasksEntity;
import com.ms.rocketseat.service.tasks.repositories.TaskRepository;
import com.ms.rocketseat.service.tasks.request.NotificationRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final NotificationClient notificationClient;

    public TaskService(TaskRepository taskRepository, NotificationClient notificationClient) {
        this.taskRepository = taskRepository;
        this.notificationClient = notificationClient;
    }

    public void sendNotificationForDueTasks() {
        LocalDateTime deadline = LocalDateTime.now().plusDays(1);
        List<TasksEntity> tasks = taskRepository.findTasksDueWithinDeadline(deadline);

        for (TasksEntity task : tasks) {
            NotificationRequest request = new NotificationRequest("Sua tarefa: " + task.getTitle() + " esta preste a vencer", task.getEmail());
            notificationClient.sendNotification(request);
            task.setNotified(true);
            taskRepository.save(task);
        }

    }
}
