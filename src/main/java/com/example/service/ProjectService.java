package com.example.service;

import com.example.entity.ProjectEntity;
import com.example.repository.ProjectRepository;

import java.util.Map;

public class ProjectService {
    public static void addProject(ProjectEntity project) {
        ProjectRepository.addProject(project);
    }

    public static void updateProject(String id, ProjectEntity project) {
        ProjectRepository.updateProject(id, project);
    }

    public static void deleteProject(String id) {
        ProjectRepository.deleteProject(id);
    }
    public static ProjectEntity getProjectById(String id) {
        return ProjectRepository.getProjectById(id);
    }

    public static Map<String, ProjectEntity> getAllProjects() {
        return ProjectRepository.getAllProjects();
    }
}