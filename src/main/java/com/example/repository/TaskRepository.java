package com.example.repository;

import com.example.entity.TaskEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TaskRepository {
    private static Map<String, TaskEntity> tasks = new HashMap<>();

    static {
        tasks.put("14", new TaskEntity("1", "Mapear banco de dados no spring boot", "14"));
        tasks.put("18", new TaskEntity("2", "Criar camadas de view no front-end", "18"));
    }

    public static TaskEntity getTaskById(String id) {
        return tasks.get(id);
    }

    public static Map<String, TaskEntity> getAllTasks() {
        return tasks;
    }
    public static void addTask(TaskEntity task) {
        tasks.put(String.valueOf(new Random().nextInt(100)), task);
    }

    public static void updateTask(String id, TaskEntity task) {
        tasks.put(id, task);
    }

    public static void deleteTask(String id) {
        tasks.remove(id);
    }
}
