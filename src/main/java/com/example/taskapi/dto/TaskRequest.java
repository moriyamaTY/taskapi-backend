package com.example.taskapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;  // 改行を含まないようにするためのインポート

import com.example.taskapi.entity.Status;

public class TaskRequest {

    @NotBlank
    @Size(max = 100)
    @Pattern(regexp = "^[^\\R]*$") // 改行を含まないようにする
    private String title;

    @Size(max = 1000)
    private String description;

    @NotNull
    private Status status; // todo, doing, done

    // ゲッターとセッター
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

}
