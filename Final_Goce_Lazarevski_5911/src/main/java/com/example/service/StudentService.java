package com.example.service;

import com.example.entity.Student;
import com.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student getStudentById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Student not found!"));
    }

    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    public Student updateStudent(Long id, Student student) {
        return repository.findById(id).map(student1 -> {
            student1.setFirstName(student.getFirstName());
            student1.setLastName(student.getLastName());
            student1.setEmail(student.getEmail());
            student1.setYear(student.getYear());
            return repository.save(student1);
        }).orElseThrow(() -> new RuntimeException("Student not found!"));
    }

    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }
}
