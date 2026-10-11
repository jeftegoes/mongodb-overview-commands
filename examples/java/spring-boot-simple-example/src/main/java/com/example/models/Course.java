package com.example.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "course")
public class Course {
    @Id
    private String id;

    @Field("description")
    private String description;

    @DocumentReference
    @Field("teacher")
    private Teacher teacher;

    @DocumentReference
    @Field("students")
    private List<Student> students;

    public Course() {
    }

    public Course(String id, String description, Teacher teacher, List<Student> students) {
        this.id = id;
        this.description = description;
        this.teacher = teacher;
        this.students = students;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", teacher=" + teacher +
                ", students=" + students +
                '}';
    }
}
