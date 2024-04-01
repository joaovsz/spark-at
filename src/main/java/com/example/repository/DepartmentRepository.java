package com.example.repository;

import com.example.entity.DepartmentEntity;

import java.util.HashMap;
import java.util.Map;

public class DepartmentRepository {
    private static final Map<String, DepartmentEntity> departments = new HashMap<>();

    static {
        departments.put("14", new DepartmentEntity("14", "Desenvolvimento"));
        departments.put("28", new DepartmentEntity("18", "Desenvolvimento 2"));
    }

    public static DepartmentEntity getDepartmentById(String id) {
        return departments.get(id);
    }

    public static Map<String, DepartmentEntity> getAllDepartments() {
        return departments;
    }
}
