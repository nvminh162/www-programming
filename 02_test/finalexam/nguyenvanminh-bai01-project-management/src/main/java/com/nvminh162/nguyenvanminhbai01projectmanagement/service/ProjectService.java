package com.nvminh162.nguyenvanminhbai01projectmanagement.service;

import com.nvminh162.nguyenvanminhbai01projectmanagement.model.Project;

import java.util.List;

public interface ProjectService {
    List<Project> findAll();

    Project findById(Long id);

    void upsert(Project project);

    void delete(Long id);
}
