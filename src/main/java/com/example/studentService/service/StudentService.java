package com.example.studentService.service;

import com.example.studentService.model.Student;
import com.example.studentService.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    public Student addStudent(String name, String surname, String classroom) {
        return studentRepository.save(new Student(name, surname, classroom));
    }

    public Student getStudent(Long id) {
        return studentRepository.findById(id);
    }

    public void updateStudentName(Long id, String name) {
        studentRepository.updateStudentNameById(id, name);
    }

    public void updateStudent(Long id, Student student) {
        Student newStudent = studentRepository.findOne(id);
        newStudent.setName(student.getName());
        newStudent.setSurname(student.getSurname());
        newStudent.setClassroom(student.getClassroom());
        studentRepository.save(newStudent);
    }

    public void deleteStudent(Long id) {
        studentRepository.delete(id);
    }
}
