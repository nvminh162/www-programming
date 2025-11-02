package com.nvminh162.course.repository;

import com.nvminh162.course.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ICourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByClassNameContaining(String className);

    @Query("SELECT c FROM Course c WHERE c.startDate <= :endDate AND c.endDate >= :startDate")
    List<Course> findCoursesInDateRange(LocalDate startDate, LocalDate endDate);
}
