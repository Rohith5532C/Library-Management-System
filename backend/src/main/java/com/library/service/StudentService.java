package com.library.service;

import com.library.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Student> getAllStudents();

    Student saveStudent(Student student);

    Optional<Student> getStudent(Long id);

    Student updateStudent(Long id, Student student);

    void deleteStudent(Long id);

}