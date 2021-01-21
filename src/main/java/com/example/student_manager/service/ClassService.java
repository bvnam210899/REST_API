package com.example.student_manager.service;

import com.example.student_manager.exception.ResourceNotFoundException;
import com.example.student_manager.model.entity.ClassDTO;
import com.example.student_manager.model.entity.StudentDTO;
import com.example.student_manager.model.in.ClassIn;
import com.example.student_manager.repository.ClassRepository;
import com.example.student_manager.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {
    @Autowired
    private ClassRepository repository;

    @Autowired
    private StudentRepository studentRepository;

    public List<ClassDTO> read() {
        return repository.findAll();
    }

    public ClassDTO create(ClassIn classIn) {
        ClassDTO classDTO = new ClassDTO();

        classDTO.setName(classIn.getName());
        classDTO = repository.save(classDTO);

        return classDTO;
    }

    public String delete(int id) {
        ClassDTO classDTO = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Class not found with id " + id));
//        if(classDTO == null) { return "Fail !"; }

        repository.delete(classDTO);

        return "Success !";
    }

    public String edit(ClassIn classIn, int id) {
        ClassDTO classDTO = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Class not found with id " + id));
//        if(classDTO == null) { return "null !"; }

        classDTO.setName(classIn.getName());
        classDTO = repository.save(classDTO);

        return "Success !";
    }
}