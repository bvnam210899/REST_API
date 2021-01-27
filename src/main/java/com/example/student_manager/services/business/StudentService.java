package com.example.student_manager.services.business;

import com.example.student_manager.exceptions.Response;
import com.example.student_manager.exceptions.ResponseDetail;
import com.example.student_manager.models.dto.StudentDTO;
import com.example.student_manager.models.entities.StudentEntity;
import com.example.student_manager.models.in.StudentIn;
import com.example.student_manager.repositories.StudentRepository;
import com.example.student_manager.services.mappers.StudentMappers;
import com.example.student_manager.services.validators.StudentInValidator;
import com.example.student_manager.untils.StringResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;
    private final StudentMappers studentMappers = new StudentMappers();

    public ResponseEntity<ResponseDetail<List<StudentDTO>>> read() {
        List<StudentDTO> studentDTOS = repository.findAllStudentsByStatusIsTrue();
        return Response.ok(studentDTOS);
    }

//    public ResponseEntity<ResponseDetail<List<StudentDTO>>> read() {
//        List<StudentEntity> studentEntities = repository.findAllStudent();
//        List<StudentDTO> studentDTOS = studentMappers.mapToStudentDTO(studentEntities);
//        return Response.ok(studentDTOS);
//    }

    public ResponseEntity<ResponseDetail<StudentDTO>> create(StudentIn studentIn) {
        ResponseEntity<ResponseDetail<StudentDTO>> validate = StudentInValidator.validateStudent(studentIn);
        if (!validate.getStatusCode().is2xxSuccessful())
            return validate;
        StudentEntity studentEntity = studentMappers.mapToStudentEntity(studentIn);
        studentEntity = repository.save(studentEntity);
        StudentDTO studentDTO = studentMappers.mapToStudentDTO(studentEntity);
        return Response.ok(studentDTO);
    }

    public ResponseEntity<ResponseDetail<StudentDTO>> delete(int id) {
        StudentEntity student = repository.findById(id).orElse(null);
        if(student == null) {
            return Response.badRequest();
        }
        repository.delete(student);
        return Response.ok();
    }

    public ResponseEntity<ResponseDetail<StudentDTO>> edit(StudentIn studentIn, int id) {
        StudentEntity studentEntity = repository.findById(id).orElse(null);
        if (studentEntity == null)
            return Response.badRequest();
        ResponseEntity<ResponseDetail<StudentDTO>> validate = StudentInValidator.validateStudent(studentIn);
        if (!validate.getStatusCode().is2xxSuccessful())
            return validate;
        studentEntity = studentMappers.mapToStudentEntity(studentIn, id);
        studentEntity = repository.save(studentEntity);
        StudentDTO studentDTO = studentMappers.mapToStudentDTO(studentEntity);
        return Response.ok(studentDTO);
    }

//    public ResponseEntity<ResponseDetail<List<StudentDTO>>> getByID(int id) {
//        List<StudentEntity> studentEntities = repository.findStudentsByClassID(id);
//        if (studentEntities.size() < 1)
//            return Response.badRequest(StringResponses.ID_NOT_VALID);
//        List<StudentDTO> studentDTOS = studentMappers.mapToStudentDTO(studentEntities);
//        return Response.ok(studentDTOS);
//    }

    public ResponseEntity<ResponseDetail<List<StudentDTO>>> getStudentsByID(int id) {
        List<StudentDTO> studentDTOS = repository.findStudentsInClassByStatusIsTrue(id);
        return Response.ok(studentDTOS);
    }
}
