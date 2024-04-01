package com.example.entity;

public class EmployeeEntity {
    private String id;
    private String name;
    private String departmentId;

    public EmployeeEntity(String id, String name, String departmentId) {
        this.id = id;
        this.name = name;
        this.departmentId = departmentId;
    }
    public EmployeeEntity(){}
    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", departmentId=" + departmentId + "]";
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

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }
}
