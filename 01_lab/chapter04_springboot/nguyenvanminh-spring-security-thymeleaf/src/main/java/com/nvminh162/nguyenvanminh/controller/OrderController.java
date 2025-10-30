package com.nvminh162.nguyenvanminh.controller;

import com.nvminh162.nguyenvanminh.model.Order;
import com.nvminh162.nguyenvanminh.model.OrderLine;
import com.nvminh162.nguyenvanminh.service.CustomerService;
import com.nvminh162.nguyenvanminh.service.OrderService;
import com.nvminh162.nguyenvanminh.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Calendar;

@Controller
@RequestMapping("/orders")
public class OrderController {
    
    @Autowired
    private OrderService orderService;
    
    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private ProductService productService;
    
    @GetMapping
    public String listOrders(Model model) {
        model.addAttribute("orders", orderService.getAllOrders());
        return "orders/list";
    }
    
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("order", new Order());
        model.addAttribute("customers", customerService.getAllCustomers());
        model.addAttribute("products", productService.getAllProducts());
        return "orders/form";
    }
    
    @GetMapping("/view/{id}")
    public String viewOrder(@PathVariable Integer id, Model model) {
        Order order = orderService.getOrderById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        
        BigDecimal total = order.getOrderLines().stream()
                .map(OrderLine::getSubTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        
        model.addAttribute("order", order);
        model.addAttribute("total", total);
        return "orders/view";
    }
    
    @PostMapping("/save")
    public String saveOrder(@RequestParam Integer customerId,
                           @RequestParam Integer[] productIds,
                           @RequestParam Integer[] amounts) {
        
        Order order = new Order();
        order.setDate(Calendar.getInstance());
        
        customerService.getCustomerById(customerId).ifPresent(order::setCustomer);
        
        for (int i = 0; i < productIds.length; i++) {
            Integer productId = productIds[i];
            Integer amount = amounts[i];
            
            if (amount > 0) {
                productService.getProductById(productId).ifPresent(product -> {
                    OrderLine orderLine = new OrderLine();
                    orderLine.setProduct(product);
                    orderLine.setAmount(amount);
                    orderLine.setPurchasePrice(product.getPrice());
                    order.addOrderLine(orderLine);
                });
            }
        }
        
        orderService.saveOrder(order);
        return "redirect:/orders";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteOrder(@PathVariable Integer id) {
        orderService.deleteOrder(id);
        return "redirect:/orders";
    }
}
