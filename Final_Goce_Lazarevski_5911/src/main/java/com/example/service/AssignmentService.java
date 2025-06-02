package com.example.service;

import com.example.entity.Assignment;
import com.example.entity.Room;
import com.example.entity.Student;
import com.example.repository.AssignmentRepository;
import com.example.repository.RoomRepository;
import com.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AssignmentService {
    @Autowired
    private AssignmentRepository assignmentRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private RoomRepository roomRepository;

    public List<Assignment> getAllAssignments() {
        return assignmentRepository.findAll();
    }

    public Optional<Assignment> findById(Long id) {
        return assignmentRepository.findById(id);
    }

    public Assignment createAssignment(Long studentId, Long roomId) {
        Student student = studentRepository.findById(studentId).orElseThrow();
        Room room = roomRepository.findById(roomId).orElseThrow();

        if (room.getCurrentOccupancy() >= room.getCapacity()) {
            throw new IllegalStateException("Room is full");
        }

        if (assignmentRepository.existsByStudentAndEndDateIsNull(student)) {
            throw new IllegalStateException("Student has active assignment");
        }

        Assignment assignment = new Assignment();
        assignment.setStudent(student);
        assignment.setRoom(room);
        assignment.setStartDate(LocalDate.now().toString());

        room.setCurrentOccupancy(room.getCurrentOccupancy() + 1);
        roomRepository.save(room);

        return assignmentRepository.save(assignment);
    }
}
