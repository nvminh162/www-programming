package com.nvminh162.nguyenvanminh.service;

import com.nvminh162.nguyenvanminh.model.Category;
import com.nvminh162.nguyenvanminh.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
    
    public Optional<Category> getCategoryById(Integer id) {
        return categoryRepository.findById(id);
    }
    
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }
    
    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
    }
}
