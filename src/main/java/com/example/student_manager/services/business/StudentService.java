package com.example.student_manager.services.business;

import com.example.student_manager.exceptions.ErrorDetails;
import com.example.student_manager.models.dto.StudentDTO;
import com.example.student_manager.models.entities.StudentEntity;
import com.example.student_manager.models.in.StudentIn;
import com.example.student_manager.repositories.StudentRepository;
import com.example.student_manager.services.mappers.StudentMappers;
import com.example.student_manager.services.validators.StudentInValidator;
import com.example.student_manager.untils.StringResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;
    private final StudentInValidator studentInValidator = new StudentInValidator();
    private final StudentMappers mapStudents = new StudentMappers();
    private ErrorDetails errorDetails;

    public List<StudentDTO> read() {

        return mapStudents.toStudentDTO(repository.findAll());
    }

    public ResponseEntity<?> create(StudentIn studentIn) {
        ResponseEntity<?> validate = studentInValidator.validateStudent(studentIn);
        if (!validate.getStatusCode().is2xxSuccessful())
            return validate;

        StudentEntity studentEntity = mapStudents.toStudentEntity(studentIn);
        studentEntity = repository.save(studentEntity);
        StudentDTO studentDTO = mapStudents.toStudentDTO(studentEntity);

        errorDetails= new ErrorDetails(HttpStatus.OK, StringResponses.SUCCESS, studentDTO);
        return new ResponseEntity<>(errorDetails, HttpStatus.OK);
    }

    public String delete(int id) {
        StudentEntity student = repository.findById(id).orElse(null);
        if(student == null) {
            return StringResponses.ID_NOT_VALID;
        }
        repository.delete(student);
        return "success";
    }

    public ResponseEntity<?> edit(StudentIn studentIn, int id) {
        StudentEntity studentEntity = repository.findById(id).orElse(null);
        if (studentEntity == null)
            return new ResponseEntity<>(new ErrorDetails(HttpStatus.BAD_REQUEST, StringResponses.ID_NOT_VALID), HttpStatus.BAD_REQUEST);

        studentEntity = mapStudents.toStudentEntity(studentIn, id);
        studentEntity = repository.save(studentEntity);
        StudentDTO studentDTO = mapStudents.toStudentDTO(studentEntity);
        errorDetails= new ErrorDetails(HttpStatus.OK, StringResponses.SUCCESS, studentDTO);
        return new ResponseEntity<>(errorDetails, HttpStatus.OK);
    }

    public List<StudentDTO> getByID(int id) {
        List<StudentEntity> studentEntities = repository.findStudentsByClassID(id);
        return mapStudents.toStudentDTO(studentEntities);
    }
}
