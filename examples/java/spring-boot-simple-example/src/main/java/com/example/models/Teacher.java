package com.example.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "teacher")
public class Teacher {
    @Id
    private String id;

    @Field("name")
    private String name;

    @Field("age")
    private Integer age;

    private TeacherDetail teacherDetail;

    public Teacher() {
    }

    public Teacher(String id, String name, Integer age, TeacherDetail teacherDetail) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.teacherDetail = teacherDetail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public TeacherDetail getTeacherDetail() {
        return teacherDetail;
    }

    public void setTeacherDetail(TeacherDetail teacherDetail) {
        this.teacherDetail = teacherDetail;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", teacherDetail=" + teacherDetail +
                '}';
    }
}
