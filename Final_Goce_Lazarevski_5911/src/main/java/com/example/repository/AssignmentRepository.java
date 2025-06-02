package com.example.repository;

import com.example.entity.Assignment;
import com.example.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    boolean existsByStudentAndEndDateIsNull(Student student);
}
