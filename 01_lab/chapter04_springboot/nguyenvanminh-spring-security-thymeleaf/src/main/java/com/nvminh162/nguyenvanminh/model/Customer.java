package com.nvminh162.nguyenvanminh.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotBlank(message = "Tên không được để trống")
    @Pattern(regexp = "^[A-Z][a-z]+(\\s+[A-Z][a-z]+)+", message = "Tên phải có ít nhất 2 từ (họ, tên) và ký tự đầu tiên mỗi từ phải viết hoa")
    private String name;
    
    @NotBlank(message = "Email không được để trống")
    @Email(message = "Địa chỉ email không hợp lệ")
    private String email;
    
    @Past(message = "Ngày phải trước ngày hiện tại")
    @NotNull(message = "Ngày không được để trống")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Calendar customerSince;
    
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<Order> orders = new ArrayList<>();
}
