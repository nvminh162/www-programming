package com.nvminh162.nguyenvanminh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {
    @GetMapping
    public String getRoot(Model model) {
        model.addAttribute("nvminh162", "Nguyễn Văn Minh - 22003405 - Spring JPA");
        return "index";
    }
}
