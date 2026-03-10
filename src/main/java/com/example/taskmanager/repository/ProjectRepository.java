package com.example.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.taskmanager.model.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProjectRepository extends JpaRepository<Project, Long> {
	Page<Project> findAll(Pageable pageable);
	
}