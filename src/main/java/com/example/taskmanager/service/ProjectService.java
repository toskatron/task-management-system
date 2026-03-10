package com.example.taskmanager.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import com.example.taskmanager.dto.CreateProjectRequest;
import com.example.taskmanager.dto.ProjectResponse;
import com.example.taskmanager.model.Project;
import com.example.taskmanager.repository.ProjectRepository;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public ProjectResponse createProject(CreateProjectRequest request) {

        Project project = new Project();

        project.setName(request.getName());
        project.setDescription(request.getDescription());

        projectRepository.save(project);

        return new ProjectResponse(
                project.getId(),
                project.getName(),
                project.getDescription()
        );
    }
    
    public Page<Project> getProjects(Pageable pageable) {
        return projectRepository.findAll(pageable);
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