package com.example.taskmanager.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.example.taskmanager.dto.CreateProjectRequest;
import com.example.taskmanager.dto.ProjectResponse;
import com.example.taskmanager.model.Project;
import com.example.taskmanager.service.ProjectService;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public Page<Project> getProjects(Pageable pageable) {
        return projectService.getProjects(pageable);
    }

    @PostMapping
    public ProjectResponse createProject(@RequestBody CreateProjectRequest request) {
        return projectService.createProject(request);
    }
}