package com.example.entity;

public class DepartmentEntity {
    private String id;
    private String name;

    public DepartmentEntity(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public DepartmentEntity(){}

    @Override
    public String toString() {
        return "Department [id=" + id + ", name=" + name + "]";
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
}
