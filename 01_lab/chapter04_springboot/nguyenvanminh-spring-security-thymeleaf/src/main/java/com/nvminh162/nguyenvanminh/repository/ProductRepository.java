package com.nvminh162.nguyenvanminh.repository;

import com.nvminh162.nguyenvanminh.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
