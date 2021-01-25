package com.example.student_manager.services.mappers;

import com.example.student_manager.models.dto.StudentDTO;
import com.example.student_manager.models.entities.StudentEntity;
import com.example.student_manager.models.in.StudentIn;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StudentMappers {
    public static List<StudentDTO> toStudentDTO(List<StudentEntity> studentEntity) {
        return studentEntity.stream()
                .map(s -> {
                    StudentDTO studentDTO = new StudentDTO();
                    studentDTO.setId(s.getId());
                    studentDTO.setName(s.getName());
                    studentDTO.setAddress(s.getAddress());
                    studentDTO.setBirthday(s.getBirthday());
                    studentDTO.setPhone_number(s.getPhone_number());
                    studentDTO.setClassEntity(s.getClassDTO());

                    return studentDTO;
                })
                .collect(Collectors.toList());
    }

    public static StudentDTO toStudentDTO(StudentEntity studentEntity) {
        StudentDTO studentDTO = new StudentDTO();

        studentDTO.setName(studentEntity.getName());
        studentDTO.setBirthday(studentEntity.getBirthday());
        studentDTO.setAddress(studentEntity.getAddress());
        studentDTO.setPhone_number(studentEntity.getPhone_number());

        return studentDTO;
    }

    public static void mapStudentIn(StudentEntity studentEntity, StudentIn studentIn){
        studentEntity.setName(studentIn.getName());
        studentEntity.setBirthday(studentIn.getBirthday());
        studentEntity.setAddress(studentIn.getAddress());
        studentEntity.setPhone_number(studentIn.getPhone_number());
        studentEntity.setClassDTO(studentIn.getClassEntity());
    }

    public static StudentEntity toStudentEntity(StudentIn studentIn) {
        StudentEntity studentEntity = new StudentEntity();
        mapStudentIn(studentEntity, studentIn);
        return studentEntity;
    }

    public static StudentEntity toStudentEntity(StudentIn studentIn, int id) {
        StudentEntity studentEntity = new StudentEntity();

        studentEntity.setId(id);
        mapStudentIn(studentEntity, studentIn);

        return studentEntity;
    }
}
