package com.nvminh162.nguyenvanminh.controller;

import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nvminh162.nguyenvanminh.model.Employee;
import com.nvminh162.nguyenvanminh.service.DepartmentService;
import com.nvminh162.nguyenvanminh.service.EmployeeService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final DepartmentService departmentService;

    @GetMapping
    public String getAllEmployees(
            @RequestParam(value = "searchName", required = false) String searchName,
            @RequestParam(value = "searchAge", required = false) Integer searchAge,
            @RequestParam(value = "departmentId", required = false) String departmentId,
            @RequestParam(value = "salaryFrom", required = false) Double salaryFrom,
            @RequestParam(value = "salaryTo", required = false) Double salaryTo,
            Model model) {
        
        java.util.List<Employee> employees;
        boolean hasSearchCriteria = false;
        
        // Check if any search criteria is provided
        String cleanSearchName = (searchName != null && !searchName.trim().isEmpty()) ? searchName.trim() : null;
        String cleanDepartmentId = (departmentId != null && !departmentId.trim().isEmpty()) ? departmentId.trim() : null;
        
        if (cleanSearchName != null || searchAge != null || cleanDepartmentId != null || 
            salaryFrom != null || salaryTo != null) {
            
            UUID deptId = null;
            if (cleanDepartmentId != null) {
                try {
                    deptId = UUID.fromString(cleanDepartmentId);
                } catch (IllegalArgumentException e) {
                    // Invalid UUID, ignore department filter
                }
            }
            
            employees = employeeService.searchEmployees(cleanSearchName, searchAge, deptId, salaryFrom, salaryTo);
            hasSearchCriteria = true;
            
            // Add attributes to preserve search form values
            model.addAttribute("searchName", searchName);
            model.addAttribute("searchAge", searchAge);
            model.addAttribute("departmentId", departmentId);
            model.addAttribute("salaryFrom", salaryFrom);
            model.addAttribute("salaryTo", salaryTo);
        } else {
            employees = employeeService.getAllEmployees();
        }
        
        model.addAttribute("employees", employees);
        model.addAttribute("departments", departmentService.getAllDepartments());
        model.addAttribute("hasSearchCriteria", hasSearchCriteria);
        return "employee/employee-list";
    }

    @GetMapping("/{id}")
    public String getEmployeeById(@PathVariable("id") String id, Model model) {
        UUID uuid = UUID.fromString(id);
        model.addAttribute("employee", employeeService.getEmployeeById(uuid));
        return "employee/employee-detail";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("departments", departmentService.getAllDepartments());
        return "employee/employee-form";
    }

    @PostMapping
    public String createEmployee(@ModelAttribute Employee employee) {
        employeeService.createEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/{id}/update")
    public String showEditForm(@PathVariable("id") String id, Model model) {
        UUID uuid = UUID.fromString(id);
        model.addAttribute("employee", employeeService.getEmployeeById(uuid));
        model.addAttribute("departments", departmentService.getAllDepartments());
        return "employee/employee-form";
    }

    @PostMapping("/{id}")
    public String updateEmployee(@PathVariable("id") String id, @ModelAttribute Employee employee) {
        UUID uuid = UUID.fromString(id);
        employee.setId(uuid);
        employeeService.updateEmployee(employee);
        return "redirect:/employees/" + id;
    }

    @PostMapping("/{id}/delete")
    public String deleteEmployee(@PathVariable("id") String id) {
        UUID uuid = UUID.fromString(id);
        employeeService.deleteEmployee(uuid);
        return "redirect:/employees";
    }
}
