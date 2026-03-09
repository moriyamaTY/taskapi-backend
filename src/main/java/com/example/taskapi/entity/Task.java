package com.example.taskapi.entity; 

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue; // IDの自動生成のためのインポート
import jakarta.persistence.GenerationType; // IDの生成方法の指定のためのインポート
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import java.time.LocalDateTime;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // IDは自動生成
    private Long id; 

    @Column(nullable = false, length = 100)
    private String title;

    @Column(length = 1000)
    private String description; 

    @Enumerated(EnumType.STRING)
    private Status status; // todo, doing, done

    private LocalDateTime createdAt; // タスクの作成日時
    private LocalDateTime updatedAt; // タスクの更新日時

    private String userId; // ユーザー認証のため
    
    @PrePersist // タスクが新規作成される前に呼び出されるメソッド
    public void createTime() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate // タスクが更新される前に呼び出されるメソッド
    public void updateTime() {
        this.updatedAt = LocalDateTime.now();
    }

    // ゲッターとセッター
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}