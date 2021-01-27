package com.example.student_manager.services.mappers;

import com.example.student_manager.models.dto.ClassDTO;
import com.example.student_manager.models.entities.ClassEntity;
import com.example.student_manager.models.in.ClassIn;

import java.util.List;
import java.util.stream.Collectors;

public class ClassMappers {
    public List<ClassDTO> toClassDTO(List<ClassEntity> classEntities) {
        return classEntities.stream()
                .map(s -> {
                    ClassDTO classDTO = new ClassDTO();
                    classDTO.setId(s.getId());
                    classDTO.setName(s.getName());
                    return classDTO;
                })
                .collect(Collectors.toList());
    }
    public ClassDTO toClassDTO(ClassEntity classEntity) {
        ClassDTO classDTO = new ClassDTO();
        classDTO.setName(classEntity.getName());
        return classDTO;
    }

    public ClassEntity toClassDTO(ClassIn classIn) {
        ClassEntity classEntity = new ClassEntity();
        classEntity.setName(classIn.getName());
        classEntity.setStatus(classIn.isStatus());
        return classEntity;
    }

    public ClassEntity toClassDTO(ClassIn classIn, int id) {
        ClassEntity classEntity = new ClassEntity();
        classEntity.setId(id);
        classEntity.setName(classIn.getName());
        classEntity.setStatus(classIn.isStatus());
        return classEntity;
    }
}
