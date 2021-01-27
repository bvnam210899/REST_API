package com.example.student_manager.models.dto;

import java.time.LocalDate;

public class StudentDTO {
    private int id;

    private String name;

    private LocalDate birthday;

    private String address;

    private String phone_number;

    private int class_id;

    private String class_name;

    public StudentDTO(int id, String name, LocalDate birthday, String address, String phone_number, int class_id, String class_name) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.phone_number = phone_number;
        this.class_id = class_id;
        this.class_name = class_name;
    }

    public StudentDTO() {
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

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }
}
