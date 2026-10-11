package com.example.repositories;

import com.example.models.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeacherRepository extends MongoRepository<Teacher, String> {
}
