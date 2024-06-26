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
                    return "Funcionario não encontrado";
                }
            });

            post("", (req, res) -> {
                EmployeeEntity employee = gson.fromJson(req.body(), EmployeeEntity.class);
                EmployeeService.addEmployee(employee);
                res.status(201);
                return "Funcionario adicionado com sucesso";
            });

            put("/:id", (req, res) -> {
                String id = req.params(":id");
                EmployeeEntity employee = gson.fromJson(req.body(), EmployeeEntity.class);
                EmployeeService.updateEmployee(id, employee);
                return "Funcionario atualizado com sucesso";
            });

            delete("/:id", (req, res) -> {
                String id = req.params(":id");
                EmployeeService.deleteEmployee(id);
                return "Funcionario deletado com sucesso";
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
                    return "Projeto não encontrado";}
            });

            post("", (req, res) -> {
                ProjectEntity project = gson.fromJson(req.body(), ProjectEntity.class);
                ProjectService.addProject(project);
                res.status(201);
                return "Projeto adicionado";
            });

            put("/:id", (req, res) -> {
                String id = req.params(":id");
                ProjectEntity project = gson.fromJson(req.body(), ProjectEntity.class);
                ProjectService.updateProject(id, project);
                return "Projeto atualizado";
            });

            delete("/:id", (req, res) -> {
                String id = req.params(":id");
                ProjectService.deleteProject(id);
                return "Projeto deletado";
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
                    return "Tarefa não encontrada";
                }
            });

            post("", (req, res) -> {
                TaskEntity task = gson.fromJson(req.body(), TaskEntity.class);
                TaskService.addTask(task);
                res.status(201);
                return "Tarefa adicionada com sucesso";
            });

            put("/:id", (req, res) -> {
                String id = req.params(":id");
                TaskEntity task = gson.fromJson(req.body(), TaskEntity.class);
                TaskService.updateTask(id, task);
                return "Tarefa atualizada com sucesso";
            });

            delete("/:id", (req, res) -> {
                String id = req.params(":id");
                TaskService.deleteTask(id);
                return "Task deletada com sucesso";
            });
        });
        get("/departments", (req, res) -> {
            res.type("application/json");
            return gson.toJson(DepartmentService.getAllDepartments().values());
        });

    }
}
