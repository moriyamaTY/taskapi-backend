package com.example.taskapi.dto;

import java.time.LocalDateTime;
import com.example.taskapi.entity.Status;
import com.example.taskapi.entity.Task;

public class TaskResponse {

    private final Long id;
    private final String title;
    private final String description;
    private final Status status;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public TaskResponse(Task task) {
        this.id = task.getId();
        this.title = task.getTitle();
        this.description = task.getDescription();
        this.status = task.getStatus();
        this.createdAt = task.getCreatedAt();
        this.updatedAt = task.getUpdatedAt();
    }

    public static TaskResponse from(Task task) {
        return new TaskResponse(task);
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

}