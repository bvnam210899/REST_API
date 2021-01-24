package com.example.student_manager.controllers;

import com.example.student_manager.models.dto.StudentDTO;
import com.example.student_manager.models.in.StudentIn;
import com.example.student_manager.services.business.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class StudentController {
    @Autowired
    private StudentService service;

    @GetMapping("/students")
    public ResponseEntity<List<StudentDTO>> read() {
        return ResponseEntity.ok(service.read());
    }

    @GetMapping("/classes/{id}/students")
    public ResponseEntity<List<StudentDTO>> getByClassId(@PathVariable("id") int id) {
        return ResponseEntity.ok(service.getByID(id));
    }

    @PostMapping("/students")
    public ResponseEntity<?> create(@RequestBody StudentIn studentIn) {
        return service.create(studentIn);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id) {
        return ResponseEntity.ok(service.delete(id));
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<?> edit(@RequestBody StudentIn studentIn, @PathVariable("id") int id) {
        return service.edit(studentIn, id);
    }
}
