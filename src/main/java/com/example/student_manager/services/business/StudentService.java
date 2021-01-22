package com.example.student_manager.services.business;

import com.example.student_manager.exceptions.EmptyException;
import com.example.student_manager.exceptions.NotFoundException;
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

    public List<StudentEntity> read() {
        return repository.findAll();
    }

    public StudentEntity create(StudentIn studentIn) throws Exception {
        studentInValidator.NullStudent(studentIn);
        StudentEntity studentEntity = studentMappers.toStudentEntity(studentIn);
        return repository.save(studentEntity);
    }

    public String delete(int id) throws NotFoundException {
        StudentEntity student = repository.findById(id).orElse(null);
        if(student == null) {
            throw new NotFoundException("ID not valid");
        }

        repository.delete(student);
        return "success";
    }

    public StudentEntity edit(StudentIn studentIn, int id) throws NotFoundException {
        StudentEntity student = repository.findById(id).orElse(null);
        if (student == null) {
            throw new NotFoundException("Id not valid");
        }

        return repository.save(studentMappers.toStudentEntity(studentIn, id));
    }

    public List<StudentEntity> getByID(int id) {
        return repository.findStudentsByClassID(id);
    }
}
