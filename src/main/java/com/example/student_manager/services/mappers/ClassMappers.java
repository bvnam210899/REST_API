package com.example.student_manager.services.mappers;

import com.example.student_manager.models.dto.ClassDTO;
import com.example.student_manager.models.entities.ClassEntity;
import com.example.student_manager.models.in.ClassIn;

public class ClassMappers {
    public ClassDTO toClassDTO(ClassEntity classEntity) {
        ClassDTO classDTO = new ClassDTO();
        classDTO.setName(classEntity.getName());
        return classDTO;
    }

    public ClassEntity toClassDTO(ClassIn classIn) {
        ClassEntity classEntity = new ClassEntity();
        classEntity.setName(classIn.getName());
        return classEntity;
    }

    public ClassEntity toClassDTO(ClassIn classIn, int id) {
        ClassEntity classEntity = new ClassEntity();
        classEntity.setId(id);
        classEntity.setName(classIn.getName());
        return classEntity;
    }
}
