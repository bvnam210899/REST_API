package com.example.student_manager.models.bo;

import com.example.student_manager.models.entities.ClassEntity;
import com.example.student_manager.models.entities.StudentEntity;

public class StudentsOfClass {
    private StudentEntity studentEntity;
    private ClassEntity classEntity;

    public StudentsOfClass(StudentEntity studentEntity, ClassEntity classEntity) {
        this.studentEntity = studentEntity;
        this.classEntity = classEntity;
    }

    public StudentEntity getStudentEntity() {
        return studentEntity;
    }

    public void setStudentEntity(StudentEntity studentEntity) {
        this.studentEntity = studentEntity;
    }

    public ClassEntity getClassEntity() {
        return classEntity;
    }

    public void setClassEntity(ClassEntity classEntity) {
        this.classEntity = classEntity;
    }
}
