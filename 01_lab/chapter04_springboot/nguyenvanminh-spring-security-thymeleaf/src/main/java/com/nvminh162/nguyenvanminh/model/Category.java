package com.nvminh162.nguyenvanminh.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotBlank(message = "Tên Category không được để trống")
    @Size(min = 2, message = "Tên Category phải có ít nhất 2 ký tự")
    @Pattern(regexp = "^[A-Z].*", message = "Tên Category phải bắt đầu bằng chữ in hoa")
    private String name;
    
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<Product> products = new ArrayList<>();
}
