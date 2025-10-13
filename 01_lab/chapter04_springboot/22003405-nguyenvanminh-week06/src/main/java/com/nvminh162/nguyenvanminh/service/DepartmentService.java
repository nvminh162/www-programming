package com.nvminh162.nguyenvanminh.service;

import java.util.List;
import java.util.UUID;

import com.nvminh162.nguyenvanminh.model.Department;

public interface DepartmentService {
    List<Department> getAllDepartments();

    Department getDepartmentById(UUID id);

    void createDepartment(Department department);

    void updateDepartment(Department department);

    void deleteDepartment(UUID id);
}
