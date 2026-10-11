package com.example.models;

import org.springframework.data.mongodb.core.mapping.Field;

public class TeacherDetail {
    @Field("hobby")
    private String hobby;

    @Field("linkedin")
    private String linkedin;

    public TeacherDetail() {
    }

    public TeacherDetail(String hobby, String linkedin) {
        this.hobby = hobby;
        this.linkedin = linkedin;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    @Override
    public String toString() {
        return "TeacherDetail{" +
                ", hobby='" + hobby + '\'' +
                ", linkedin='" + linkedin + '\'' +
                '}';
    }
}
