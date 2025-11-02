package com.nvminh162.nguyenvanminhbai01projectmanagement.service.impl;

import com.nvminh162.nguyenvanminhbai01projectmanagement.model.Project;
import com.nvminh162.nguyenvanminhbai01projectmanagement.repository.IProjectRepository;
import com.nvminh162.nguyenvanminhbai01projectmanagement.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private final IProjectRepository iProjectRepository;

    @Override
    public List<Project> findAll() {
        return iProjectRepository.findAll();
    }

    @Override
    public Project findById(Long id) {
        return iProjectRepository.findById(id).orElse(null);
    }

    // create, update
    @Override
    public void upsert(Project project) {
        iProjectRepository.save(project);
    }

    @Override
    public void delete(Long id) {
        iProjectRepository.deleteById(id);
    }
}
