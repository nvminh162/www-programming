package com.nvminh162.nguyenvanminh.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nvminh162.nguyenvanminh.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, UUID> {}