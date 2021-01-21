package com.example.student_manager.service;

import com.example.student_manager.exception.ResourceNotFoundException;
import com.example.student_manager.model.entity.StudentDTO;
import com.example.student_manager.model.in.StudentIn;
import com.example.student_manager.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;

    public List<StudentDTO> read() {
        return repository.findAll();
    }

    public StudentDTO create(StudentIn studentIn) {
        StudentDTO student = new StudentDTO();

        student.setName(studentIn.getName());
        student.setBirthday(studentIn.getBirthday());
        student.setAddress(studentIn.getAddress());
        student.setPhone_number(studentIn.getPhone_number());
        student.setClassDTO(studentIn.getClassDTO());
        student = repository.save(student);

        return student;
    }

    public String delete(int id) {
        StudentDTO student = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + id));
//        if(student == null) { return "Fail !"; }

        repository.delete(student);

        return "success";
    }

    public String edit(StudentIn studentIn, int id) {
        StudentDTO student = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + id));
//        if (student == null) { return "Fail !"; }

        student.setName(studentIn.getName());
        student.setBirthday(studentIn.getBirthday());
        student.setAddress(studentIn.getAddress());
        student.setPhone_number(studentIn.getPhone_number());
        student.setClassDTO(studentIn.getClassDTO());
        repository.save(student);

        return "Success !";
    }

    public List<StudentDTO> getByID(int id) {
        return repository.findStudentsByClassID(id);
    }

    public List<StudentDTO> getByIDFilter(int id) {
        return repository.findAll().stream()
                .filter(studentDTO -> id == studentDTO.getClassDTO().getId())
                .collect(Collectors.toList());
    }
}
