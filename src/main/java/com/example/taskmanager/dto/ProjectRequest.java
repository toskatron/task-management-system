package com.example.taskmanager.dto;
import jakarta.validation.constraints.NotBlank;

public class ProjectRequest {

    @NotBlank
    private String name;

    private String description;

    private Long ownerId;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
}