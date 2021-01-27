package com.example.student_manager.services.business;

import com.example.student_manager.exceptions.Response;
import com.example.student_manager.exceptions.ResponseDetail;
import com.example.student_manager.models.dto.ClassDTO;
import com.example.student_manager.models.entities.ClassEntity;
import com.example.student_manager.models.in.ClassIn;
import com.example.student_manager.repositories.ClassRepository;
import com.example.student_manager.services.mappers.ClassMappers;
import com.example.student_manager.services.validators.ClassEntityValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {
    @Autowired
    private ClassRepository repository;
    private final ClassMappers classMappers = new ClassMappers();

    public ResponseEntity<ResponseDetail<List<ClassDTO>>> read() {
        List<ClassEntity> classEntities = repository.findAll();
        List<ClassDTO> classDTOS = classMappers.toClassDTO(classEntities);
        return Response.ok(classDTOS);
    }

    public ResponseEntity<ResponseDetail<ClassDTO>> create(ClassIn classIn) {
        ResponseEntity<ResponseDetail<ClassDTO>> validate = ClassEntityValidator.validateClass(classIn);
        if (!validate.getStatusCode().is2xxSuccessful())
            return validate;

        ClassEntity classEntity = classMappers.toClassDTO(classIn);
        classEntity = repository.save(classEntity);
        ClassDTO classDTO = classMappers.toClassDTO(classEntity);
        return Response.ok(classDTO);
    }

    public ResponseEntity<ResponseDetail<ClassDTO>> delete(int id) {
        ClassEntity classEntity = repository.findById(id).orElse(null);
        if(classEntity == null) {
            return Response.badRequest();
        }
        repository.delete(classEntity);
        return Response.ok();
    }

    public ResponseEntity<ResponseDetail<ClassDTO>> edit(ClassIn classIn, int id) {
        ClassEntity classEntity = repository.findById(id).orElse(null);
        if(classEntity == null) {
            return Response.badRequest();
        }
        ResponseEntity<ResponseDetail<ClassDTO>> validate = ClassEntityValidator.validateClass(classIn);
        if (!validate.getStatusCode().is2xxSuccessful())
            return validate;
        classEntity = classMappers.toClassDTO(classIn, id);
        classEntity = repository.save(classEntity);
        ClassDTO classDTO = classMappers.toClassDTO(classEntity);

        return Response.ok(classDTO);
    }
}