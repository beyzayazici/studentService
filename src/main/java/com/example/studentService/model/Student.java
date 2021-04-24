package com.example.studentService.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue
    private long id;
    @NotNull
    private String name;
    @NotNull
    private String surname;
    @NotNull
    private String classroom;

    public Student(String name, String surname, String classroom) {
        this.name = name;
        this.surname = surname;
        this.classroom = classroom;
    }

    public Student() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }
}
