package com.nvminh162.nguyenvanminh.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "order_lines")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    @ToString.Exclude
    private Order order;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    @ToString.Exclude
    private Product product;
    
    private Integer amount;
    
    private BigDecimal purchasePrice;
    
    public BigDecimal getSubTotal() {
        if (purchasePrice != null && amount != null) {
            return purchasePrice.multiply(new BigDecimal(amount));
        }
        return BigDecimal.ZERO;
    }
}
