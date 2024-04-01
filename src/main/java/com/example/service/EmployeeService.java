package com.example.service;

import com.example.entity.EmployeeEntity;
import com.example.repository.EmployeeRepository;

import java.util.Map;

public class EmployeeService {
    public static EmployeeEntity getEmployeeById(String id) {
        return EmployeeRepository.getEmployeeById(id);
    }

    public static Map<String, EmployeeEntity> getAllEmployees() {
        return EmployeeRepository.getAllEmployees();
    }
    public static void addEmployee(EmployeeEntity employee) {
        EmployeeRepository.addEmployee(employee);
    }

    public static void updateEmployee(String id, EmployeeEntity employee) {
        EmployeeRepository.updateEmployee(id, employee);
    }

    public static void deleteEmployee(String id) {
        EmployeeRepository.deleteEmployee(id);
    }
}