package com.example.studentService.repository;

import com.example.studentService.model.Student;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Transactional
    @Modifying
    @Query("update Student s set s.name = :name where s.id = :id")
    void updateStudentNameById(@Param(value ="id") long id, @Param(value ="name")String name);
}
