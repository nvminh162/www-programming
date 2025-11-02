package com.nvminh162.nguyenvanminhbai01projectmanagement.controller;

import com.nvminh162.nguyenvanminhbai01projectmanagement.model.Project;
import com.nvminh162.nguyenvanminhbai01projectmanagement.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;

    @ModelAttribute
    public void addCommonAttrs(Model model, Authentication auth) {
        if (auth == null) return;
        // IN: [ADMIN, MEMBER]
        // OUT: ADMIN, MEMBER
        String roleName = auth.getAuthorities()
                .stream()
                .map(i -> i.getAuthority())
                .collect(Collectors.joining(","));
        model.addAttribute("name", auth.getName());
        model.addAttribute("roleName", roleName);
    }

    @GetMapping
    public String showProjectList(Model model, Authentication authentication) {
        model.addAttribute("projects", projectService.findAll());
        return "project-list";
    }

    @GetMapping("/form")
    @PreAuthorize("hasRole('ADMIN')")
    public String showProjectForm(Model model, @RequestParam(required = false, defaultValue = "0") Long id) {
        Project project = projectService.findById(id);
        model.addAttribute("project", project != null ? project : new Project());
        return "project-form";
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public String saveProject(Project project) {
        projectService.upsert(project);
        return "redirect:/projects";
    }

    @PostMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteProject(@PathVariable Long id) {
        projectService.delete(id);
        return "redirect:/projects";
    }
}
