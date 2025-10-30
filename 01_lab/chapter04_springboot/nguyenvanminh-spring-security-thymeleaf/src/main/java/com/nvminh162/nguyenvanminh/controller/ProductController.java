package com.nvminh162.nguyenvanminh.controller;

import com.nvminh162.nguyenvanminh.model.Comment;
import com.nvminh162.nguyenvanminh.model.Product;
import com.nvminh162.nguyenvanminh.service.CategoryService;
import com.nvminh162.nguyenvanminh.service.CommentService;
import com.nvminh162.nguyenvanminh.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {
    
    @Autowired
    private ProductService productService;
    
    @Autowired
    private CategoryService categoryService;
    
    @Autowired
    private CommentService commentService;
    
    @GetMapping
    public String listProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products/list";
    }
    
    @GetMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public String showAddForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "products/form";
    }
    
    @GetMapping("/edit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Product product = productService.getProductById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.getAllCategories());
        return "products/form";
    }
    
    @PostMapping("/save")
    @PreAuthorize("hasRole('ADMIN')")
    public String saveProduct(@ModelAttribute Product product, @RequestParam(required = false) Integer categoryId) {
        if (categoryId != null) {
            categoryService.getCategoryById(categoryId).ifPresent(product::setCategory);
        }
        productService.saveProduct(product);
        return "redirect:/products";
    }
    
    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }
    
    @GetMapping("/view/{id}")
    public String viewProduct(@PathVariable Integer id, Model model) {
        Product product = productService.getProductById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        model.addAttribute("product", product);
        model.addAttribute("comments", commentService.getCommentsByProductId(id));
        model.addAttribute("newComment", new Comment());
        return "products/view";
    }
    
    @PostMapping("/{id}/comments")
    public String addComment(@PathVariable Integer id, @RequestParam String text) {
        Product product = productService.getProductById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        
        Comment comment = Comment.builder()
                .text(text)
                .product(product)
                .build();
        
        commentService.saveComment(comment);
        return "redirect:/products/view/" + id;
    }
}
