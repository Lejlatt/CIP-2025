package com.example.controller;

import com.example.entity.Room;
import com.example.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    @Autowired
    private RoomService service;

    @GetMapping
    public List<Room> getAllRooms() {
        return service.getAllRooms();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getRoomById(id));
    }

    @PostMapping
    public ResponseEntity<Room> addStudent(@RequestBody Room room) {
        return ResponseEntity.ok(service.saveRoom(room));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable Long id, @RequestBody Room room) {
        room.setId(id);
        return ResponseEntity.ok(service.updateRoom(id, room));
    }

    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable Long id) {
        service.deleteRoom(id);
    }
}
