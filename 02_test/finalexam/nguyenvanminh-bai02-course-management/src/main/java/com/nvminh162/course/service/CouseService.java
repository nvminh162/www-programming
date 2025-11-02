package com.nvminh162.course.service;

import com.nvminh162.course.model.Course;

import java.time.LocalDate;
import java.util.List;

public interface CouseService {
    List<Course> findAll();

    List<Course> findByClassName(String className);

    List<Course> findCoursesInDateRange(LocalDate startDate, LocalDate endDate);

    Course findById(Long id);

    void upsert(Course couse);

    void delete(Long id);

    void openCourse(Long id);
}
