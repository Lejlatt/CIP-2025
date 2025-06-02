package com.example.service;

import com.example.entity.Room;
import com.example.entity.Student;
import com.example.repository.RoomRepository;
import com.example.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataInitializer {
    @Bean
    CommandLineRunner initDatabase(StudentRepository studentRepository, RoomRepository roomRepository) {
        return args -> {
            populateDatabase(studentRepository, roomRepository);
        };
    }

    @Transactional
    public void populateDatabase(StudentRepository studentRepository, RoomRepository roomRepository) {
        List<Student> students = studentRepository.saveAll(List.of(
                new Student("Goce", "Lazarevski", "goce@123.com", Student.YearEnum.SOPHOMORE),
                new Student("Gocka", "Lazarev", "gocka@321.com", Student.YearEnum.SENIOR),
                new Student("Gogo", "Lazarov", "gogo@yahoo.com", Student.YearEnum.SOPHOMORE),
                new Student("Georgi", "Lazareski", "georgi@gmail.com", Student.YearEnum.SOPHOMORE),
                new Student("Gjorgji", "Lazarevikj", "gjorgji@gmail.com", Student.YearEnum.FRESHMAN),
                new Student("George", "Lazarus", "george@outlook.com", Student.YearEnum.FRESHMAN)
        ));

        List<Room> rooms = roomRepository.saveAll(List.of(
                new Room("A", 5, "55", 4, 3),
                new Room("B", 0, "03", 3, 1),
                new Room("C", 3, "36", 4, 2),
                new Room("D", 2, "21", 6, 3)
        ));
    }
}

