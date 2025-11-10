package com.nvminh162.nguyenvanminh.repository;

import com.nvminh162.nguyenvanminh.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
