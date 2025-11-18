package com.legacy.services;

import com.legacy.models.Customer;
import com.legacy.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

// Legacy code with issues:
// - Field injection instead of constructor injection
// - No error handling
// - Business logic mixed with data access
// - No logging
// - No transaction management
@Service
public class CustomerService {

    @Autowired // Using field injection - not recommended
    private CustomerRepo customerRepo;

    // No validation
    public Customer createCustomer(Customer customer) {
        customer.createdDate = new Date(); // Using deprecated Date
        customer.active = true;
        return customerRepo.save(customer);
    }

    // Returns null instead of Optional
    public Customer getCustomer(Long id) {
        return customerRepo.findById(id).orElse(null);
    }

    // No error handling
    public Customer findByEmail(String email) {
        return customerRepo.findByEmail(email);
    }

    // Returns all customers - no pagination
    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    // No validation before update
    public Customer updateCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    // No soft delete option
    public void deleteCustomer(Long id) {
        customerRepo.deleteById(id);
    }

    // No authentication or authorization
    public boolean authenticate(String email, String password) {
        Customer customer = customerRepo.findByEmail(email);
        if (customer == null) {
            return false;
        }
        // Plain text password comparison - SECURITY ISSUE
        return customer.password.equals(password);
    }

    // Inefficient search
    public List<Customer> searchCustomers(String name) {
        List<Customer> all = customerRepo.findAll();
        return all.stream()
                .filter(c -> c.name.contains(name))
                .toList();
    }
}
