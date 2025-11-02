package com.nvminh162.nguyenvanminhbai01projectmanagement.repository;

import com.nvminh162.nguyenvanminhbai01projectmanagement.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProjectRepository extends JpaRepository<Project, Long> {}
