package com.nvminh162.nguyenvanminh.repository;

import com.nvminh162.nguyenvanminh.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findByProductId(Integer productId);
}
