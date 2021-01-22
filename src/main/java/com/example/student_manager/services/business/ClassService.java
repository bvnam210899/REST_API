package com.example.student_manager.services.business;

import com.example.student_manager.exceptions.EmptyException;
import com.example.student_manager.exceptions.NotFoundException;
import com.example.student_manager.models.dto.ClassDTO;
import com.example.student_manager.models.entities.ClassEntity;
import com.example.student_manager.models.in.ClassIn;
import com.example.student_manager.repositories.ClassRepository;
import com.example.student_manager.repositories.StudentRepository;
import com.example.student_manager.services.mappers.ClassMappers;
import com.example.student_manager.services.validators.ClassEntityValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {
    @Autowired
    private ClassRepository repository;

    private ClassMappers classMappers = new ClassMappers();

    private ClassEntityValidator classEntityValidator = new ClassEntityValidator();

    public List<ClassDTO> read() {
        return classMappers.toClassDTO(repository.findAll());
    }

    public ClassDTO create(ClassIn classIn) throws EmptyException {

        classEntityValidator.NullClass(classIn);
        ClassEntity classEntity = classMappers.toClassDTO(classIn);
        return classMappers.toClassDTO(repository.save(classEntity));
    }

    public String delete(int id) throws NotFoundException {
        ClassEntity classEntity = repository.findById(id).orElse(null);
        if(classEntity == null) {
            throw new NotFoundException("Id no valid");
        }

        repository.delete(classEntity);

        return "Success !";
    }

    public ClassDTO edit(ClassIn classIn, int id) throws NotFoundException {
        ClassEntity classEntity = repository.findById(id).orElse(null);
        if(classEntity == null) {
            throw new NotFoundException("id not valid");
        }

        return classMappers.toClassDTO(repository.save(classEntity));
    }
}