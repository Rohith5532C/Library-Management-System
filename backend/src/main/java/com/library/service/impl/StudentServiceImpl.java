package com.library.service.impl;

import com.library.entity.Student;
import com.library.repository.StudentRepository;
import com.library.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    @Override
    public Optional<Student> getStudent(Long id) {
        return repository.findById(id);
    }

    @Override
    public Student updateStudent(Long id, Student student) {

        Student existing = repository.findById(id).orElseThrow();

        existing.setStudentId(student.getStudentId());
        existing.setName(student.getName());
        existing.setEmail(student.getEmail());
        existing.setPhone(student.getPhone());
        existing.setDepartment(student.getDepartment());
        existing.setYear(student.getYear());

        return repository.save(existing);
    }

    @Override
    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }
}