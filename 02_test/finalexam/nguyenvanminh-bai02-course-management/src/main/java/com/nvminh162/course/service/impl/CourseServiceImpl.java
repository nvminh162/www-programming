package com.nvminh162.course.service.impl;

import com.nvminh162.course.model.Course;
import com.nvminh162.course.repository.ICourseRepository;
import com.nvminh162.course.service.CouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CouseService {

    private final ICourseRepository iCourseRepository;

    @Override
    public List<Course> findAll() {
        return iCourseRepository.findAll();
    }

    @Override
    public List<Course> findByClassName(String className) {
        return iCourseRepository.findByClassNameContaining(className);
    }

    @Override
    public List<Course> findCoursesInDateRange(LocalDate startDate, LocalDate endDate) {
        return iCourseRepository.findCoursesInDateRange(startDate, endDate);
    }

    @Override
    public Course findById(Long id) {
        return iCourseRepository.findById(id).orElse(null);
    }

    @Override
    public void upsert(Course couse) {
        iCourseRepository.save(couse);
    }

    @Override
    public void delete(Long id) {
        iCourseRepository.deleteById(id);
    }

    @Override
    public void openCourse(Long id) {
        Course course = iCourseRepository.findById(id).orElse(null);
        if (course != null) {
            course.setOpen(true);
            iCourseRepository.save(course);
        }
    }
}
