package com.example.student_manager.repositories;

import com.example.student_manager.models.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
    @Query("SELECT s FROM StudentEntity s WHERE s.classEntity.id = :id")
    List<StudentEntity> findStudentsByClassID(@Param("id") int id);
}
