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

    public String updateStudentName(Long id, String name) {
        Student newStudent = studentRepository.findOne(id);
        var result = new StringBuilder();
        result.append(id).append(" numaralı öğrenci ");
        try {
            if(newStudent != null) {
                studentRepository.updateStudentNameById(id, name);
                return result.append("başarıyla güncellendi.").toString();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result.append("bulunamadı.Güncelleme işlemi yapılamadı").toString();
    }

    public String updateStudent(Long id, Student student) {
        Student newStudent = studentRepository.findOne(id);
        var result = new StringBuilder();
        result.append(id).append(" numaralı öğrenci ");
        try {
            if(newStudent != null) {
                newStudent.setName(student.getName());
                newStudent.setSurname(student.getSurname());
                newStudent.setClassroom(student.getClassroom());
                studentRepository.save(newStudent);
                return result.append("başarıyla güncellendi.").toString();
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return result.append("bulunamadı.Güncelleme işlemi yapılamadı.").toString();
    }

    public String deleteStudent(Long id) {
        Student newStudent = studentRepository.findOne(id);
        var result = new StringBuilder();
        result.append(id).append(" numaralı öğrenci ");
        try {
            if(newStudent != null) {
                studentRepository.delete(id);
                return result.append("silindi.").toString();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result.append("bulunamadı.Silme işlemi yapılamadı.").toString();
    }
}
