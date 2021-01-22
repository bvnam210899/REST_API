package com.example.student_manager.services.business;

import com.example.student_manager.exceptions.EmptyException;
import com.example.student_manager.exceptions.NotFoundException;
import com.example.student_manager.models.dto.StudentDTO;
import com.example.student_manager.models.entities.StudentEntity;
import com.example.student_manager.models.in.StudentIn;
import com.example.student_manager.repositories.StudentRepository;
import com.example.student_manager.services.mappers.StudentMappers;
import com.example.student_manager.services.validators.StudentInValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    private StudentInValidator studentInValidator = new StudentInValidator();

    private StudentMappers studentMappers = new StudentMappers();

    public List<StudentDTO> read() {

        return studentMappers.toStudentDTO(repository.findAll());
    }

    public StudentDTO create(StudentIn studentIn) throws EmptyException {
        studentInValidator.NullStudent(studentIn);
        StudentEntity studentEntity = studentMappers.toStudentEntity(studentIn);

        return studentMappers.toStudentDTO(repository.save(studentEntity));
    }

    public String delete(int id) throws NotFoundException {
        StudentEntity student = repository.findById(id).orElse(null);
        if(student == null) {
            throw new NotFoundException("ID not valid");
        }

        repository.delete(student);
        return "success";
    }

    public StudentDTO edit(StudentIn studentIn, int id) throws NotFoundException {
        StudentEntity studentEntity = repository.findById(id).orElse(null);
        if (studentEntity == null) {
            throw new NotFoundException("Id not valid");
        }

        return studentMappers.toStudentDTO(repository.save(studentMappers.toStudentEntity(studentIn, id)));
    }

    public List<StudentDTO> getByID(int id) {
        return studentMappers.toStudentDTO(repository.findStudentsByClassID(id));
    }
}
