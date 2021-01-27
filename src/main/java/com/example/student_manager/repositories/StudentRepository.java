package com.example.student_manager.repositories;

import com.example.student_manager.models.dto.StudentDTO;
import com.example.student_manager.models.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
    @Query("SELECT new com.example.student_manager.models.dto.StudentDTO(s.id, s.name, s.birthday, s.address, s.phone_number, c.id, c.name) FROM StudentEntity s INNER JOIN ClassEntity c ON s.class_id = c.id WHERE s.status = true")
    List<StudentDTO> findAllStudentsByStatusIsTrue();

//    @Query("SELECT StudentEntity FROM StudentEntity s INNER JOIN ClassEntity c ON s.class_id = c.id WHERE s.status = true")
//    List<StudentEntity> findAllStudent();

    @Query("SELECT new com.example.student_manager.models.dto.StudentDTO(s.id, s.name, s.birthday, s.address, s.phone_number, c.id, c.name) FROM StudentEntity s INNER JOIN ClassEntity c ON s.class_id = c.id WHERE c.id = :id and s.status = true")
    List<StudentDTO> findStudentsInClassByStatusIsTrue(@Param("id") int id);
}
