package com.legacy.models;

import jakarta.persistence.*;
import java.util.Date;

// Legacy code with issues:
// - Using Date instead of LocalDateTime
// - No validation
// - Public fields (no encapsulation)
// - No constructors
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public String name;
    public String email;
    public String password; // Stored in plain text - SECURITY ISSUE
    public String address;
    public String phone;

    @Temporal(TemporalType.TIMESTAMP)
    public Date createdDate; // Using deprecated Date class

    public Boolean active;

    // No validation
    // No encapsulation
    // No business logic
}
