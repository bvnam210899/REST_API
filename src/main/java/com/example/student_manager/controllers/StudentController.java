package com.example.student_manager.controllers;

import com.example.student_manager.exceptions.EmptyException;
import com.example.student_manager.exceptions.NotFoundException;
import com.example.student_manager.models.dto.StudentDTO;
import com.example.student_manager.models.in.StudentIn;
import com.example.student_manager.services.business.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class StudentController {
    @Autowired
    private StudentService service;

    @GetMapping("/students")
    public ResponseEntity<List<StudentDTO>> read() {
        return ResponseEntity.ok(service.read());
    }

    @GetMapping("/students/{id}/classes")
    public ResponseEntity<List<StudentDTO>> getByClassId(@PathVariable("id") int id) {
        return ResponseEntity.ok(service.getByID(id));
    }

    @PostMapping("/students")
    public ResponseEntity<StudentDTO> create(@RequestBody StudentIn studentIn) throws EmptyException {
        return ResponseEntity.ok(service.create(studentIn));
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id) throws NotFoundException {
        return ResponseEntity.ok(service.delete(id));
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<StudentDTO> edit(@RequestBody StudentIn studentIn, @PathVariable("id") int id) throws NotFoundException {
        return ResponseEntity.ok(service.edit(studentIn, id));
    }
}
