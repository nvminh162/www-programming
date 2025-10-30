package com.nvminh162.nguyenvanminh.repository;

import com.nvminh162.nguyenvanminh.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
