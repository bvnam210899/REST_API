package com.example.student_manager.service;

import com.example.student_manager.model.entity.ClassDTO;
import com.example.student_manager.model.in.ClassIn;
import com.example.student_manager.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {
    @Autowired
    private ClassRepository repository;

    public List<ClassDTO> read() {
        return repository.findAll();
    }

    public ClassDTO create(ClassIn classIn) {
        ClassDTO classEntity = new ClassDTO();

        classEntity.setName(classIn.getName());
        classEntity = repository.save(classEntity);

        return classEntity;
    }

    public String delete(int id) {
        ClassDTO classEntity = repository.findById(id).orElse(null);
        if(classEntity == null) { return "Fail !"; }

        repository.delete(classEntity);

        return "Success !";
    }

    public String edit(ClassIn classIn, int id) {
        ClassDTO classEntity = repository.findById(id).orElse(null);
        if(classEntity == null) {
            return "null !";
        }

        classEntity.setName(classIn.getName());
        classEntity = repository.save(classEntity);

        return "Success !";
    }
}
