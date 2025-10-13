package com.nvminh162.nguyenvanminh.controller;

import com.nvminh162.nguyenvanminh.model.Customer;
import com.nvminh162.nguyenvanminh.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;
    
    @GetMapping
    public String listCustomers(Model model) {
        model.addAttribute("customers", customerService.getAllCustomers());
        return "customers/list";
    }
    
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customers/form";
    }
    
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Customer customer = customerService.getCustomerById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        model.addAttribute("customer", customer);
        return "customers/form";
    }
    
    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute Customer customer) {
        if (customer.getCustomerSince() == null) {
            customer.setCustomerSince(Calendar.getInstance());
        }
        customerService.saveCustomer(customer);
        return "redirect:/customers";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Integer id) {
        customerService.deleteCustomer(id);
        return "redirect:/customers";
    }
    
    @GetMapping("/view/{id}")
    public String viewCustomer(@PathVariable Integer id, Model model) {
        Customer customer = customerService.getCustomerById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        model.addAttribute("customer", customer);
        return "customers/view";
    }
}
