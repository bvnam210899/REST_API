package com.example.student_manager.models.in;

import com.example.student_manager.models.entities.ClassEntity;

import java.time.LocalDate;
import java.util.Date;

public class StudentIn {

    private String name;

    private LocalDate birthday;

    private String address;

    private String phone_number;

    private ClassEntity classEntity;

    public ClassEntity getClassEntity() {
        return classEntity;
    }

    public void setClassDTO(ClassEntity classEntity) {
        this.classEntity = classEntity;
    }

    public StudentIn() {
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
}
