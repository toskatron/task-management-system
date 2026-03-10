package com.example.taskmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.model.TaskStatus;
import com.example.taskmanager.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @GetMapping("/project/{projectId}")
    public List<Task> getTasksByProject(@PathVariable Long projectId) {
        return taskService.getTasksByProject(projectId);
    }

    @PutMapping("/{id}/status")
    public Task updateTaskStatus(@PathVariable Long id, @RequestParam TaskStatus status) {
        return taskService.updateTaskStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}