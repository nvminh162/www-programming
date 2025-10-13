package com.nvminh162.nguyenvanminh.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nvminh162.nguyenvanminh.model.Employee;
import com.nvminh162.nguyenvanminh.repository.EmployeeRepository;
import com.nvminh162.nguyenvanminh.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(UUID id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee); // JPA save method works for both create and update
    }

    @Override
    public void deleteEmployee(UUID id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> getEmployeesByDepartmentId(UUID departmentId) {
        return employeeRepository.findByDepartmentId(departmentId);
    }

    @Override
    public List<Employee> getEmployeesByName(String name) {
        return employeeRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public List<Employee> getEmployeesByAge(int age) {
        return employeeRepository.findByAge(age);
    }

    @Override
    public List<Employee> getEmployeesBySalaryRange(double from, double to) {
        return employeeRepository.findBySalaryBetween(from, to);
    }
    
    @Override
    public List<Employee> searchEmployees(String name, Integer age, UUID departmentId, Double salaryFrom, Double salaryTo) {
        return employeeRepository.searchEmployees(name, age, departmentId, salaryFrom, salaryTo);
    }
}
