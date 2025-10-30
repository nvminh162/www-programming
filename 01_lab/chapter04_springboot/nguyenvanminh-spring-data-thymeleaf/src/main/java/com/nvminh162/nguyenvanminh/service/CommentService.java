package com.nvminh162.nguyenvanminh.service;

import com.nvminh162.nguyenvanminh.model.Comment;
import com.nvminh162.nguyenvanminh.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    
    @Autowired
    private CommentRepository commentRepository;
    
    public List<Comment> getCommentsByProductId(Integer productId) {
        return commentRepository.findByProductId(productId);
    }
    
    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }
    
    public void deleteComment(Integer id) {
        commentRepository.deleteById(id);
    }
}
