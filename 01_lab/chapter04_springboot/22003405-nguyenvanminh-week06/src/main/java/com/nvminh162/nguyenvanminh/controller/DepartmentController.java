package com.nvminh162.nguyenvanminh.controller;

import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nvminh162.nguyenvanminh.model.Department;
import com.nvminh162.nguyenvanminh.service.DepartmentService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping
    public String getAllDepartments(Model model) {
        model.addAttribute("departments", departmentService.getAllDepartments());
        return "department/department-list";
    }

    @GetMapping("/{id}")
    public String getDepartmentById(@PathVariable("id") String id, Model model) {
        UUID uuid = UUID.fromString(id);
        model.addAttribute("department", departmentService.getDepartmentById(uuid));
        return "department/department-detail";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("department", new Department());
        return "department/department-form";
    }

    @PostMapping
    public String createDepartment(@ModelAttribute Department department) {
        departmentService.createDepartment(department);
        return "redirect:/departments";
    }

    @GetMapping("/{id}/update")
    public String showEditForm(@PathVariable("id") String id, Model model) {
        UUID uuid = UUID.fromString(id);
        model.addAttribute("department", departmentService.getDepartmentById(uuid));
        return "department/department-form";
    }

    @PostMapping("/{id}")
    public String updateDepartment(@PathVariable("id") String id, @ModelAttribute Department department) {
        UUID uuid = UUID.fromString(id);
        department.setId(uuid);
        departmentService.updateDepartment(department);
        return "redirect:/departments/" + id;
    }

    @PostMapping("/{id}/delete")
    public String deleteDepartment(@PathVariable("id") String id) {
        UUID uuid = UUID.fromString(id);
        departmentService.deleteDepartment(uuid);
        return "redirect:/departments";
    }
}
