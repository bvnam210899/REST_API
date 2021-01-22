package com.example.student_manager.models.dto;

import com.example.student_manager.models.entities.ClassEntity;

import java.time.LocalDate;

public class StudentDTO {
    private int id;

    private String name;

    private LocalDate birthday;

    private String address;

    private String phone_number;

    private ClassEntity classEntity;

    public StudentDTO() {
    }

    public StudentDTO(int id, String name, LocalDate birthday, String address, String phone_number) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.phone_number = phone_number;
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public ClassEntity getClassEntity() {
        return classEntity;
    }

    public void setClassEntity(ClassEntity classEntity) {
        this.classEntity = classEntity;
    }
}
