package com.example.student_manager.controller;

import com.example.student_manager.model.entity.StudentDTO;
import com.example.student_manager.model.in.StudentIn;
import com.example.student_manager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService service;

    @GetMapping
    public List<StudentDTO> read() {
        return service.read();
    }

    @GetMapping("/get2/{id}")
    public List<StudentDTO> getByIDFilter(@PathVariable("id") int id) {
        return service.getByIDFilter(id);
    }

    @GetMapping("/class/{id}")
    public List<StudentDTO> getByClassId(@PathVariable("id") int id) {
        return service.getByID(id);
    }

    @PostMapping
    public StudentDTO create(@RequestBody StudentIn studentIn) { return service.create(studentIn); }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        return service.delete(id);
    }

    @PutMapping("/{id}")
    public String edit(@RequestBody StudentIn studentIn, @PathVariable("id") int id) {
        return service.edit(studentIn, id);
    }
}
