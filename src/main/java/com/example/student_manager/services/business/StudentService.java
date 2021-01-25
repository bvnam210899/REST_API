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

//    public List<StudentDTO> read() {
//        List<StudentEntity> studentEntities = repository.findAll();
//        return StudentMappers.toStudentDTO(studentEntities);
//    }
    public ResponseEntity<ResponseDetail<Object>> read() {
        List<StudentEntity> studentEntities = repository.findAll();
        List<StudentDTO> studentDTOS = StudentMappers.toStudentDTO(studentEntities);
        return Response.ok(studentDTOS);
    }

    public ResponseEntity<ResponseDetail<Object>> create(StudentIn studentIn) {
        ResponseEntity<ResponseDetail<Object>> validate = StudentInValidator.validateStudent(studentIn);
        if (!validate.getStatusCode().is2xxSuccessful())
            return validate;

        StudentEntity studentEntity = StudentMappers.toStudentEntity(studentIn);
        studentEntity = repository.save(studentEntity);
        StudentDTO studentDTO = StudentMappers.toStudentDTO(studentEntity);

        return Response.ok(studentDTO);
    }

    public ResponseEntity<ResponseDetail<Object>> delete(int id) {
        StudentEntity student = repository.findById(id).orElse(null);
        if(student == null) {
            return Response.badRequest(StringResponses.ID_NOT_VALID);
        }
        repository.delete(student);
        return Response.ok();
    }

    public ResponseEntity<ResponseDetail<Object>> edit(StudentIn studentIn, int id) {
        StudentEntity studentEntity = repository.findById(id).orElse(null);
        if (studentEntity == null)
            return Response.badRequest(StringResponses.ID_NOT_VALID);
        ResponseEntity<ResponseDetail<Object>> validate = StudentInValidator.validateStudent(studentIn);
        if (!validate.getStatusCode().is2xxSuccessful())
            return validate;
        studentEntity = StudentMappers.toStudentEntity(studentIn, id);
        studentEntity = repository.save(studentEntity);
        StudentDTO studentDTO = StudentMappers.toStudentDTO(studentEntity);
        return Response.ok(studentDTO);
    }

//    public List<StudentDTO> getByID(int id) {
//        List<StudentEntity> studentEntities = repository.findStudentsByClassID(id);
//        return StudentMappers.toStudentDTO(studentEntities);
//    }

    public ResponseEntity<ResponseDetail<Object>> getByID(int id) {
        List<StudentEntity> studentEntities = repository.findStudentsByClassID(id);
        if (studentEntities.size() < 1)
            return Response.badRequest(studentEntities);
        List<StudentDTO> studentDTOS = StudentMappers.toStudentDTO(studentEntities);
        return Response.ok(studentDTOS);
    }
}
