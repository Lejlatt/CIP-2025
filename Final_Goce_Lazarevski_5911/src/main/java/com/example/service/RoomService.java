package com.example.service;

import com.example.entity.Room;
import com.example.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomRepository repository;

    public List<Room> getAllRooms() {
        return repository.findAll();
    }

    public Room getRoomById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Room not found!"));
    }

    public Room saveRoom(Room room) {
        return repository.save(room);
    }

    public Room updateRoom(Long id, Room room) {
        return repository.findById(id).map(room1 -> {
            room1.setBuilding(room.getBuilding());
            room1.setFloor(room.getFloor());
            room1.setNumber(room.getNumber());
            room1.setCapacity(room.getCapacity());
            room1.setCurrentOccupancy(room.getCurrentOccupancy());
            return repository.save(room1);
        }).orElseThrow(() -> new RuntimeException("Room not found!"));
    }

    public void deleteRoom(Long id) {
        repository.deleteById(id);
    }
}
