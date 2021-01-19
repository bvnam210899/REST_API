package com.example.student_manager.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class StudentDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private Date birthday;

    @Column
    private String address;

    @Column
    private String phone_number;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "class_id")
    private ClassDTO classDTO;

    public ClassDTO getClassDTO() {
        return classDTO;
    }

    public void setClassDTO(ClassDTO classDTO) {
        this.classDTO = classDTO;
    }

    public StudentDTO () {
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
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

