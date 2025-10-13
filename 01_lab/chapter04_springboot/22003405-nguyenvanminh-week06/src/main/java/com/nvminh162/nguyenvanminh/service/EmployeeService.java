package com.nvminh162.nguyenvanminh.service;

import java.util.List;
import java.util.UUID;

import com.nvminh162.nguyenvanminh.model.Employee;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee getEmployeeById(UUID id);

    void createEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void deleteEmployee(UUID id);

    List<Employee> getEmployeesByDepartmentId(UUID departmentId);

    List<Employee> getEmployeesByName(String name);

    List<Employee> getEmployeesByAge(int age);

    List<Employee> getEmployeesBySalaryRange(double from, double to);
    
    List<Employee> searchEmployees(String name, Integer age, UUID departmentId, Double salaryFrom, Double salaryTo);
}
