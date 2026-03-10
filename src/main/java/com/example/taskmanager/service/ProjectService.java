package com.example.taskmanager.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taskmanager.dto.ProjectRequest;
import com.example.taskmanager.dto.ProjectResponse;
import com.example.taskmanager.model.Project;
import com.example.taskmanager.repository.ProjectRepository;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public ProjectResponse createProject(ProjectRequest request) {

        Project project = new Project();
        project.setName(request.getName());
        project.setDescription(request.getDescription());

        Project saved = projectRepository.save(project);

        return new ProjectResponse(
                saved.getId(),
                saved.getName(),
                saved.getDescription());
    }

    public List<ProjectResponse> getAllProjects() {

        return projectRepository.findAll()
                .stream()
                .map(p -> new ProjectResponse(
                        p.getId(),
                        p.getName(),
                        p.getDescription()))
                .collect(Collectors.toList());
    }
}