package com.nvminh162.nguyenvanminh.repository;

import com.nvminh162.nguyenvanminh.model.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine, Integer> {
}
