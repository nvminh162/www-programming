package com.nvminh162.nguyenvanminh.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    
    @Column(name = "name", nullable = false)
    String name;
    
    @Column(name = "email", nullable = false, unique = true)
    String email;
    
    @Column(name = "age")
    int age;
    
    @Column(name = "salary")
    double salary;
    
    @Column(name = "status")
    int status;
    
    @ManyToOne
    @JoinColumn(name = "department_id")
    Department department;
}
