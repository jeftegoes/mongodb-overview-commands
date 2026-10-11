package com.example.controllers;

import com.example.models.Student;
import com.example.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    StudentRepository studentRepository;

    @GetMapping
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable String id) {
        return studentRepository.findById(id).orElse(null);
    }

    @PostMapping
    public void create(@RequestBody Student student) {
        studentRepository.save(student);
    }

    @DeleteMapping
    public void delete(@RequestBody Student student) {
        studentRepository.delete(student);
    }

    @PutMapping
    public void update(@RequestBody Student student) {
        studentRepository.save(student);
    }
}
