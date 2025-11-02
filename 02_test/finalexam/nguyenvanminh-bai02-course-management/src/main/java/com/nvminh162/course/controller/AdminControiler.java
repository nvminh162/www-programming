package com.nvminh162.course.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
public class AdminControiler {

    @ModelAttribute
    public void addCommonsAttrs(Model model, Authentication auth) {
        if (auth == null) return;
        String roleName = auth.getAuthorities()
                .stream()
                .map(i -> i.getAuthority())
                .collect(Collectors.joining(","));
        model.addAttribute("name", auth.getName());
        model.addAttribute("roleName", roleName);
    }

    @GetMapping
    public String showAdmin() {
        return "admin";
    }
}
