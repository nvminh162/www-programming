package com.nvminh162.course.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "courses")
@Data
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Course {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String className;
    String subject;
    int noOfStudents;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate endDate;

    boolean isOpen;

    public Course() {
        this.isOpen = false;
    }
}
