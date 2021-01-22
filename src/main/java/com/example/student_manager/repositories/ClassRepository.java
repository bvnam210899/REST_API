package com.example.student_manager.repositories;

import com.example.student_manager.models.entities.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<ClassEntity, Integer> {

}
