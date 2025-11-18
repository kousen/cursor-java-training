package com.legacy.repositories;

import com.legacy.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

// Legacy code with issues:
// - Inconsistent naming (Repo vs Repository)
// - Raw SQL queries instead of JPQL
// - No proper error handling
@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

    // Using native SQL instead of JPQL - less portable
    @Query(value = "SELECT * FROM customers WHERE email = ?1", nativeQuery = true)
    Customer findByEmail(String email);

    // SQL injection vulnerability - concatenating strings
    @Query(value = "SELECT * FROM customers WHERE name LIKE %?1%", nativeQuery = true)
    List<Customer> searchByName(String name);

    @Query(value = "SELECT * FROM customers WHERE active = 1", nativeQuery = true)
    List<Customer> getActiveCustomers();
}
