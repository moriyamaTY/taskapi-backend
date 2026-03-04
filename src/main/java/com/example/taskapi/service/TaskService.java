package com.example.taskapi.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.web.server.ResponseStatusException;
import com.example.taskapi.entity.Task;
import com.example.taskapi.repository.TaskRepository;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    
    public List<Task> getAllTasks(String userId) {
        return taskRepository.findByUserId(userId);
    }

    public Task getTaskById(Long id, String userId) {
        return taskRepository.findByIdAndUserId(id, userId).orElseThrow(() 
        -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found"));
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTask(Long id, String userId) {
        Task task = getTaskById(id, userId);
        taskRepository.delete(task);
    }

    public Task updateTask(Long id, String userId, Task updatedTask) {
        Task task = getTaskById(id, userId);

        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());
        task.setStatus(updatedTask.getStatus());

        return taskRepository.save(task);
    }
}
