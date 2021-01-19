package com.example.student_manager.repository;

import com.example.student_manager.model.entity.StudentDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentDTO, Integer> {
    @Query("SELECT s FROM StudentDTO s WHERE s.classDTO.id = :id")
    List<StudentDTO> findStudentsByNameQuery(@Param("id") int id);
}
