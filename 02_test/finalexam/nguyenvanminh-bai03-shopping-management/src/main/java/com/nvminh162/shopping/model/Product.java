package com.nvminh162.shopping.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;
    double price;
    boolean inStock;

    @OneToMany(mappedBy = "product")
    @ToString.Exclude
    List<OrderLine> orderLines;

    @OneToMany(mappedBy = "product")
    @ToString.Exclude
    List<Comment> comments;

    @OneToMany(mappedBy = "product")
    @ToString.Exclude
    List<Category> categories;
}
