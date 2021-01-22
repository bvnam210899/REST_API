package com.example.student_manager.models.dto;

public class ClassDTO {
    private int id;

    private String name;

    public ClassDTO() {
    }

    public ClassDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
