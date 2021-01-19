package com.example.student_manager.controller;

import com.example.student_manager.model.entity.ClassDTO;
import com.example.student_manager.model.in.ClassIn;
import com.example.student_manager.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classes")
public class ClassController {

    @Autowired
    private ClassService service;

    @GetMapping
    public List<ClassDTO> read() {
        return service.read();
    }

    @PostMapping
    public ClassDTO create(@RequestBody ClassIn classIn) {
        return service.create(classIn);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        return service.delete(id);
    }

    @PutMapping("/{id}")
    public String edit(@RequestBody ClassIn classIn, @PathVariable("id") int id) {
        return service.edit(classIn, id);
    }
}
