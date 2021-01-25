package com.example.student_manager.controllers;

import com.example.student_manager.exceptions.ResponseDetail;
import com.example.student_manager.models.in.StudentIn;
import com.example.student_manager.services.business.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class StudentController {
    @Autowired
    private StudentService service;

    @GetMapping("/students")
    public ResponseEntity<ResponseDetail<Object>> read() {
        return service.read();
    }

    @GetMapping("/classes/{id}/students")
    public ResponseEntity<ResponseDetail<Object>> getByClassId(@PathVariable("id") int id) {
        return service.getByID(id);
    }

    @PostMapping("/students")
    public ResponseEntity<ResponseDetail<Object>> create(@RequestBody StudentIn studentIn) {
        return service.create(studentIn);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<ResponseDetail<Object>> delete(@PathVariable("id") int id) {
        return service.delete(id);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<ResponseDetail<Object>> edit(@RequestBody StudentIn studentIn, @PathVariable("id") int id) {
        return service.edit(studentIn, id);
    }
}
