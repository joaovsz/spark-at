package com.example.repository;

import com.example.entity.EmployeeEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class EmployeeRepository {
    private static Map<String, EmployeeEntity> employees = new HashMap<>();

    static {
        employees.put("1", new EmployeeEntity("1", "Erica Ribeiro", "1"));
        employees.put("2", new EmployeeEntity("2", "Gabriel Kraus", "2"));
    }

    public static EmployeeEntity getEmployeeById(String id) {
        return employees.get(id);
    }

    public static Map<String, EmployeeEntity> getAllEmployees() {
        return employees;
    }
    public static void addEmployee(EmployeeEntity employee) {
         Random random = new Random();

        ;
        employees.put(String.valueOf(random.nextInt(1000)), new EmployeeEntity(String.valueOf(random.nextInt(1000)),employee.getName(), employee.getDepartmentId()));
    }

    public static void updateEmployee(String id, EmployeeEntity employee) {
        employees.put(id, employee);
    }

    public static void deleteEmployee(String id) {
        employees.remove(id);
    }
}
