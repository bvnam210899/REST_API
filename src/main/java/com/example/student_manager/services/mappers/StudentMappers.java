package com.example.student_manager.services.mappers;

import com.example.student_manager.models.dto.StudentDTO;
import com.example.student_manager.models.entities.StudentEntity;
import com.example.student_manager.models.in.StudentIn;

import java.util.List;
import java.util.stream.Collectors;

public class StudentMappers {
    public List<StudentDTO> mapToStudentDTO(List<StudentEntity> studentEntity) {
        return studentEntity.stream()
                .map(s -> {
                    StudentDTO studentDTO = new StudentDTO();
                    studentDTO.setId(s.getId());
                    studentDTO.setName(s.getName());
                    studentDTO.setAddress(s.getAddress());
                    studentDTO.setBirthday(s.getBirthday());
                    studentDTO.setPhone_number(s.getPhone_number());
                    studentDTO.setClass_id(s.getClass_id());
                    studentDTO.setClass_name(s.getClass_name());
                    return studentDTO;
                })
                .collect(Collectors.toList());
    }

    public StudentDTO mapToStudentDTO(StudentEntity studentEntity) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setName(studentEntity.getName());
        studentDTO.setBirthday(studentEntity.getBirthday());
        studentDTO.setAddress(studentEntity.getAddress());
        studentDTO.setPhone_number(studentEntity.getPhone_number());
        return studentDTO;
    }

    public void mapStudentEntityToStudentEntity(StudentEntity studentEntity, StudentIn studentIn){
        studentEntity.setName(studentIn.getName());
        studentEntity.setBirthday(studentIn.getBirthday());
        studentEntity.setAddress(studentIn.getAddress());
        studentEntity.setPhone_number(studentIn.getPhone_number());
        studentEntity.setStatus(studentIn.isStatus());
        studentEntity.setClass_id(studentIn.getClass_id());
    }

    public StudentEntity mapToStudentEntity(StudentIn studentIn) {
        StudentEntity studentEntity = new StudentEntity();
        mapStudentEntityToStudentEntity(studentEntity, studentIn);
        return studentEntity;
    }

    public StudentEntity mapToStudentEntity(StudentIn studentIn, int id) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(id);
        mapStudentEntityToStudentEntity(studentEntity, studentIn);
        return studentEntity;
    }
}
