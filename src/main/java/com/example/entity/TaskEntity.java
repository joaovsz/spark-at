package com.example.entity;

public class TaskEntity {
    private String id;
    private String name;
    private String projectId;

    public TaskEntity(String id, String name, String projectId) {
        this.id = id;
        this.name = name;
        this.projectId = projectId;
    }
    public TaskEntity(){}

    @Override
    public String toString() {
        return "Task [id=" + id + ", name=" + name + ", projectId=" + projectId + "]";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
}
