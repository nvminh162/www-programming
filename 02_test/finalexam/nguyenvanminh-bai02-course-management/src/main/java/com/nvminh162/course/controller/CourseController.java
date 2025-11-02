package com.nvminh162.course.controller;

import com.nvminh162.course.model.Course;
import com.nvminh162.course.service.CouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {

    private final CouseService couseService;

    @ModelAttribute
    public void addCommonsAttrs(Model model, Authentication auth) {
        if (auth == null) return;
        String roleName = auth.getAuthorities()
                .stream()
                .map(i -> i.getAuthority())
                .collect(Collectors.joining(","));
        model.addAttribute("name", auth.getName());
        model.addAttribute("roleName", roleName);
    }

    @GetMapping
    public String showCourses(
            Model model,
            @RequestParam(required = false) String className,
            @RequestParam(required = false) LocalDate startDate,
            @RequestParam(required = false) LocalDate endDate
    ) {
        if (className != null) {
            model.addAttribute("courses", couseService.findByClassName(className));
        } else if (startDate != null && endDate != null) {
            model.addAttribute("courses", couseService.findCoursesInDateRange(startDate, endDate));
        } else {
            model.addAttribute("courses", couseService.findAll());
        }
        return "course-list";
    }

    @GetMapping("/form")
    @PreAuthorize("hasAnyRole('ADMIN', 'TEACHER')")
    public String showForm(Model model, @RequestParam(required = false, defaultValue = "0") Long id) {
        Course course = couseService.findById(id);
        model.addAttribute("course", course != null ? course : new Course());
        return "course-form";
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'TEACHER')")
    public String upsertCourse(Course course) {
        couseService.upsert(course);
        return "redirect:/courses";
    }

    @PostMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteCourse(@PathVariable Long id) {
        couseService.delete(id);
        return "redirect:/courses";
    }

    @PostMapping("/open/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String openCourse(@PathVariable Long id) {
        couseService.openCourse(id);
        return "redirect:/courses";
    }
}
