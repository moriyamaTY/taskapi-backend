package com.example.taskapi.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;
import jakarta.validation.Valid;

import com.example.taskapi.entity.Task;
import com.example.taskapi.service.TaskService;
import com.example.taskapi.dto.TaskRequest;
import com.example.taskapi.dto.TaskResponse;

@RestController
@RequestMapping("/tasks") // ベースURLを/tasksに設定
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    
    // 全件取得
    @GetMapping
    public List<TaskResponse> getAllTasks(@RequestHeader("X-USER-ID") String userId) {
        List<Task> tasks = taskService.getAllTasks(userId);
        // TaskResponseに変換して返す
        return tasks.stream().map(TaskResponse::from).collect(Collectors.toList());
    }

    // 1件取得
    @GetMapping("/{id}")
    public TaskResponse getTask(@PathVariable Long id, @RequestHeader("X-USER-ID") String userId) {
        Task task = taskService.getTaskById(id, userId);
        return TaskResponse.from(task); // TaskResponseに変換して返す
    }

    // 新規作成
    @PostMapping
    public TaskResponse createTask(@Valid @RequestBody TaskRequest request, @RequestHeader("X-USER-ID") String userId) { //
        // TaskRequestからTaskエンティティに変換
        Task task = new Task();
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setStatus(request.getStatus());
        task.setUserId(userId);

        Task saved = taskService.createTask(task); 
        return new TaskResponse(saved); // TaskResponseに変換して返す
    }

    // 削除
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id, @RequestHeader("X-USER-ID") String userId) {
        taskService.deleteTask(id, userId);
    }

    // 更新
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestHeader("X-USER-ID") String userId, @Valid @RequestBody Task task) {
        return taskService.updateTask(id, userId, task);
    }
}