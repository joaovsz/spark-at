package com.example.service;

import com.example.entity.DepartmentEntity;
import com.example.repository.DepartmentRepository;

import java.util.Map;

public class DepartmentService {
    public static DepartmentEntity getDepartmentById(String id) {
        return DepartmentRepository.getDepartmentById(id);
    }

    public static Map<String, DepartmentEntity> getAllDepartments() {
        return DepartmentRepository.getAllDepartments();
    }
}
