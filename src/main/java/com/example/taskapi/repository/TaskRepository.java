package com.example.taskapi.repository; 

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;
import com.example.taskapi.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUserId(String userId); 
    Optional<Task> findByIdAndUserId(Long id, String userId); //タスクが存在しない場合はnullを返す
}