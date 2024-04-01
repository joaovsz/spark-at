package com.example.service;

import com.example.entity.TaskEntity;
import com.example.repository.TaskRepository;

import java.util.Map;

public class TaskService {
    public static TaskEntity getTaskById(String id) {
        return TaskRepository.getTaskById(id);
    }

    public static Map<String, TaskEntity> getAllTasks() {
        return TaskRepository.getAllTasks();
    }
    public static void addTask(TaskEntity task) {
        TaskRepository.addTask(task);
    }

    public static void updateTask(String id, TaskEntity task) {
        TaskRepository.updateTask(id, task);
    }

    public static void deleteTask(String id) {
        TaskRepository.deleteTask(id);
    }
}