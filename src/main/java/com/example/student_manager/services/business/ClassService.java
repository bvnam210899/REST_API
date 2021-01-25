package com.example.student_manager.services.business;

import com.example.student_manager.exceptions.Response;
import com.example.student_manager.exceptions.ResponseDetail;
import com.example.student_manager.models.dto.ClassDTO;
import com.example.student_manager.models.entities.ClassEntity;
import com.example.student_manager.models.in.ClassIn;
import com.example.student_manager.repositories.ClassRepository;
import com.example.student_manager.services.mappers.ClassMappers;
import com.example.student_manager.services.validators.ClassEntityValidator;
import com.example.student_manager.untils.StringResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {
    @Autowired
    private ClassRepository repository;

    public List<ClassDTO> read() {
        List<ClassEntity> classEntities = repository.findAll();
        return ClassMappers.toClassDTO(classEntities);
    }

    public ResponseEntity<?> create(ClassIn classIn) {
        ResponseEntity<?> validate = ClassEntityValidator.validateClass(classIn);
        if (!validate.getStatusCode().is2xxSuccessful())
            return validate;

        ClassEntity classEntity = ClassMappers.toClassDTO(classIn);
        classEntity = repository.save(classEntity);
        ClassDTO classDTO = ClassMappers.toClassDTO(classEntity);
        return Response.ok(classDTO);
    }

    public ResponseEntity<?> delete(int id) {
        ClassEntity classEntity = repository.findById(id).orElse(null);
        if(classEntity == null) {
            return Response.badRequest(StringResponses.ID_NOT_VALID);
        }
        repository.delete(classEntity);
        return Response.ok();
    }

    public ResponseEntity<?> edit(ClassIn classIn, int id) {
        ClassEntity classEntity = repository.findById(id).orElse(null);
        if(classEntity == null) {
            return Response.badRequest(StringResponses.ID_NOT_VALID);
        }
        ResponseEntity<?> validate = ClassEntityValidator.validateClass(classIn);
        if (!validate.getStatusCode().is2xxSuccessful())
            return validate;
        classEntity = ClassMappers.toClassDTO(classIn, id);
        classEntity = repository.save(classEntity);
        ClassDTO classDTO = ClassMappers.toClassDTO(classEntity);

        return Response.ok(classDTO);
    }
}