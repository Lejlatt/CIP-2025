package com.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "STUDENT")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    @Enumerated(EnumType.STRING)
    private YearEnum yearEnum;

    public enum YearEnum {
        FRESHMAN,
        SOPHOMORE,
        SENIOR
    }

    public Student() {
    }

    public Student(String firstName, String lastName, String email, YearEnum yearEnum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.yearEnum = yearEnum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public YearEnum getYear() {
        return yearEnum;
    }

    public void setYear(YearEnum yearEnum) {
        this.yearEnum = yearEnum;
    }
}
