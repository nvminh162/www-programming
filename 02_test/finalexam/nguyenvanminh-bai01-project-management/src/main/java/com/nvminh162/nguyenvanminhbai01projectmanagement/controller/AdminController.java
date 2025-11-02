package com.nvminh162.nguyenvanminhbai01projectmanagement.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    @ModelAttribute
    public void addCommonAttrs(Model model, Authentication auth) {
        if (auth == null) return;
        // IN: [ADMIN, MEMBER]
        // OUT: ADMIN, MEMBER
        String roleName = auth.getAuthorities()
                .stream()
                .map(i -> i.getAuthority())
                .collect(Collectors.joining(","));
        model.addAttribute("name", auth.getName());
        model.addAttribute("roleName", roleName);
    }

    @GetMapping
    public String admin() {
        return "admin";
    }
}
