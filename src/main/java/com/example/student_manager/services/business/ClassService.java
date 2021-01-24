package com.example.student_manager.services.business;

import com.example.student_manager.models.dto.ClassDTO;
import com.example.student_manager.models.entities.ClassEntity;
import com.example.student_manager.models.in.ClassIn;
import com.example.student_manager.repositories.ClassRepository;
import com.example.student_manager.services.mappers.ClassMappers;
import com.example.student_manager.services.validators.ClassEntityValidator;
import com.example.student_manager.untils.StringResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {
    @Autowired
    private ClassRepository repository;

    private final ClassMappers classMappers = new ClassMappers();

    private final ClassEntityValidator classEntityValidator = new ClassEntityValidator();

    public List<ClassDTO> read() {
        return classMappers.toClassDTO(repository.findAll());
    }

    public ClassDTO create(ClassIn classIn) {
        classEntityValidator.validateClass(classIn);
        ClassEntity classEntity = classMappers.toClassDTO(classIn);
        classEntity = repository.save(classEntity);
        return classMappers.toClassDTO(classEntity);
    }

    public String delete(int id) {
        ClassEntity classEntity = repository.findById(id).orElse(null);
        if(classEntity == null) {
            return StringResponses.ID_NOT_VALID;
        }
        repository.delete(classEntity);
        return "Success !";
    }

//    public ClassDTO edit(ClassIn classIn, int id) {
//        ClassEntity classEntity = repository.findById(id).orElse(null);
//        if(classEntity == null) {
//            return StringResponses.ID_NOT_VALID;
//        }
//        classEntity = repository.save(classEntity);
//        return classMappers.toClassDTO(classEntity);
//    }
}