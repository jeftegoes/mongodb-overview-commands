package com.example.controllers;

import com.example.models.Teacher;
import com.example.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {
    @Autowired
    TeacherRepository teacherRepository;

    @GetMapping
    public List<Teacher> getAll() {
        return teacherRepository.findAll();
    }

    @GetMapping("/{id}")
    public Teacher getById(@PathVariable String id) {
        return teacherRepository.findById(id).orElse(null);
    }

    @PostMapping
    public void create(@RequestBody Teacher teacher) {
        teacherRepository.save(teacher);
    }

    @DeleteMapping
    public void delete(@RequestBody Teacher teacher) {
        teacherRepository.delete(teacher);
    }

    @PutMapping
    public void update(@RequestBody Teacher teacher) {
        teacherRepository.save(teacher);
    }
}
