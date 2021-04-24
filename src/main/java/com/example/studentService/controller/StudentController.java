package com.example.studentService.controller;

import com.example.studentService.model.Student;
import com.example.studentService.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping(path = "/api/students")
@RestController
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents() {
        return studentService.findAllStudents();
    }

    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody String name, String surname, String classroom) {
        return studentService.addStudent(name, surname, classroom);
    }

    @GetMapping("/getStudentById/{id}")
    public Student getStudent(@PathVariable Long id) {
        return studentService.getStudent(id);
    }

    @PutMapping("/updateStudentName/{id}")
    public void updateStudent(@RequestBody String name, @PathVariable Long id) {
        studentService.updateStudentName(id, name);
    }

    @PutMapping("/updateStudent/{id}")
    public void updateStudent(@RequestBody Student student, @PathVariable Long id) {
        studentService.updateStudent(id, student);
    }

    @DeleteMapping("/deleteStudentById/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}
