package com.legacy.controllers;

import com.legacy.models.Customer;
import com.legacy.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Legacy code with issues:
// - No proper error handling
// - No validation
// - No DTOs (exposing entities directly)
// - No proper HTTP status codes
// - No API versioning
// - Security vulnerabilities
@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // No validation
    @PostMapping
    public Customer create(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    // Exposes all data including password
    @GetMapping("/{id}")
    public Customer get(@PathVariable Long id) {
        return customerService.getCustomer(id);
    }

    // Returns all customers - no pagination
    @GetMapping
    public List<Customer> getAll() {
        return customerService.getAllCustomers();
    }

    // No validation
    @PutMapping
    public Customer update(@RequestBody Customer customer) {
        return customerService.updateCustomer(customer);
    }

    // No error handling
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }

    // Security vulnerability - exposes authentication endpoint
    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {
        boolean authenticated = customerService.authenticate(email, password);
        if (authenticated) {
            return "Success";
        }
        return "Failed";
    }

    // SQL injection vulnerability through service layer
    @GetMapping("/search")
    public List<Customer> search(@RequestParam String name) {
        return customerService.searchCustomers(name);
    }

    // No proper exception handling
    @GetMapping("/email/{email}")
    public Customer findByEmail(@PathVariable String email) {
        return customerService.findByEmail(email);
    }
}
