package com.example.controller;
import com.example.entity.EmployeeEntity;
import com.example.entity.ProjectEntity;
import com.example.entity.TaskEntity;
import com.example.service.DepartmentService;
import com.example.service.EmployeeService;
import com.example.service.ProjectService;
import com.example.service.TaskService;
import com.google.gson.Gson;
import com.google.gson.Gson;

import static spark.Spark.*;

public class ControllerSpark {

    public static void setupRoutes() {
        port(4567);
        Gson gson = new Gson();
        options("/*", (request, response) -> {
            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }

            return "OK";
        });

        before((request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
        });
        path("/employees", () -> {
            get("", (req, res) -> {
                res.type("application/json");
                return gson.toJson(EmployeeService.getAllEmployees().values());
            });

            get("/:id", (req, res) -> {
                String id = req.params(":id");
                EmployeeEntity employee = EmployeeService.getEmployeeById(id);
                if (employee != null) {
                    res.type("application/json");
                    return gson.toJson(employee);
                } else {
                    res.status(404);
                    return "Employee not found";
                }
            });

            post("", (req, res) -> {
                EmployeeEntity employee = gson.fromJson(req.body(), EmployeeEntity.class);
                EmployeeService.addEmployee(employee);
                res.status(201);
                return "Employee added successfully";
            });

            put("/:id", (req, res) -> {
                String id = req.params(":id");
                EmployeeEntity employee = gson.fromJson(req.body(), EmployeeEntity.class);
                EmployeeService.updateEmployee(id, employee);
                return "Employee updated successfully";
            });

            delete("/:id", (req, res) -> {
                String id = req.params(":id");
                EmployeeService.deleteEmployee(id);
                return "Employee deleted successfully";
            });
        });

        path("/projects", () -> {
            get("", (req, res) -> {
                res.type("application/json");
                return gson.toJson(ProjectService.getAllProjects().values());
            });

            get("/:id", (req, res) -> {
                String id = req.params(":id");
                ProjectEntity project = ProjectService.getProjectById(id);
                if (project != null) {
                    res.type("application/json");
                    return gson.toJson(project);
                } else {
                    res.status(404);
                    return "Project not found";
                }
            });

            post("", (req, res) -> {
                ProjectEntity project = gson.fromJson(req.body(), ProjectEntity.class);
                ProjectService.addProject(project);
                res.status(201);
                return "Project added successfully";
            });

            put("/:id", (req, res) -> {
                String id = req.params(":id");
                ProjectEntity project = gson.fromJson(req.body(), ProjectEntity.class);
                ProjectService.updateProject(id, project);
                return "Project updated successfully";
            });

            delete("/:id", (req, res) -> {
                String id = req.params(":id");
                ProjectService.deleteProject(id);
                return "Project deleted successfully";
            });
        });

        path("/tasks", () -> {
            get("", (req, res) -> {
                res.type("application/json");
                return gson.toJson(TaskService.getAllTasks().values());
            });

            get("/:id", (req, res) -> {
                String id = req.params(":id");
                TaskEntity task = TaskService.getTaskById(id);
                if (task != null) {
                    res.type("application/json");
                    return gson.toJson(task);
                } else {
                    res.status(404);
                    return "Task not found";
                }
            });

            post("", (req, res) -> {
                TaskEntity task = gson.fromJson(req.body(), TaskEntity.class);
                TaskService.addTask(task);
                res.status(201);
                return "Task added successfully";
            });

            put("/:id", (req, res) -> {
                String id = req.params(":id");
                TaskEntity task = gson.fromJson(req.body(), TaskEntity.class);
                TaskService.updateTask(id, task);
                return "Task updated successfully";
            });

            delete("/:id", (req, res) -> {
                String id = req.params(":id");
                TaskService.deleteTask(id);
                return "Task deleted successfully";
            });
        });
        get("/departments", (req, res) -> {
            res.type("application/json");
            return gson.toJson(DepartmentService.getAllDepartments().values());
        });

    }
}
