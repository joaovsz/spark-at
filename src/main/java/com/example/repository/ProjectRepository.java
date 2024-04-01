package com.example.repository;

import com.example.entity.ProjectEntity;

import java.util.HashMap;
import java.util.Map;

public class ProjectRepository {
    private static Map<String, ProjectEntity> projects = new HashMap<>();

    static {
        projects.put("14", new ProjectEntity("14", "Solicitação de Procedimentos", "14"));
        projects.put("18", new ProjectEntity("18", "Criação de Agendas pela Web", "18"));
    }

    public static ProjectEntity getProjectById(String id) {
        return projects.get(id);
    }

    public static Map<String, ProjectEntity> getAllProjects() {
        return projects;
    }
    public static void addProject(ProjectEntity project) {
        projects.put(project.getId(), project);
    }

    public static void updateProject(String id, ProjectEntity project) {
        projects.put(id, project);
    }

    public static void deleteProject(String id) {
        projects.remove(id);
    }
}
