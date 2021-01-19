package com.example.student_manager.repository;

import com.example.student_manager.model.entity.ClassDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClassRepository extends JpaRepository<ClassDTO, Integer> {

}
