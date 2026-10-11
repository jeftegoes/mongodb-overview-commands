package com.example.controllers;

import com.example.models.Course;
import com.example.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    @Autowired
    CourseRepository courseRepository;

    @GetMapping
    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    @GetMapping("/{id}")
    public Course getById(@PathVariable String id) {
        return courseRepository.findById(id).orElse(null);
    }

    @PostMapping
    public void create(@RequestBody Course course) {
        courseRepository.save(course);
    }

    @DeleteMapping
    public void delete(@RequestBody Course course) {
        courseRepository.delete(course);
    }

    @PutMapping
    public void update(@RequestBody Course course) {
        courseRepository.save(course);
    }
}
