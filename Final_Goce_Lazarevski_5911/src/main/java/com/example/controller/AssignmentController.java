package com.example.controller;

import com.example.entity.Assignment;
import com.example.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class AssignmentController {
    @Autowired
    private AssignmentService assignmentService;

    @GetMapping
    public List<Assignment> getAllAssignments() {
        return assignmentService.getAllAssignments();
    }

    @PostMapping("/rooms/{roomId}/students/{studentId}/assignments")
    public ResponseEntity<Assignment> createAssignment(
            @PathVariable Long roomId,
            @PathVariable Long studentId) {
        return ResponseEntity.ok(assignmentService.createAssignment(studentId, roomId));
    }

    @PatchMapping("/assignments/{id}/checkout")
    public ResponseEntity<Assignment> checkout(@PathVariable Long id) {
        Optional<Assignment> assignmentOpt = assignmentService.findById(id);

        if (assignmentOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        Assignment assignment = assignmentOpt.get();

        LocalDate today = LocalDate.now();
        LocalDate assignmentEndDate = LocalDate.parse(assignment.getEndDate());

        if (assignmentEndDate.isBefore(today)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(assignment);
        }

        return ResponseEntity.ok(assignment);
    }
}
