package com.nvminh162.nguyenvanminh.service;

import com.nvminh162.nguyenvanminh.model.Customer;
import com.nvminh162.nguyenvanminh.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    
    @Autowired
    private CustomerRepository customerRepository;
    
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    
    public Optional<Customer> getCustomerById(Integer id) {
        return customerRepository.findById(id);
    }
    
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
    
    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }
}
