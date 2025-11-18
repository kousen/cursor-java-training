package com.legacy.models;

import jakarta.persistence.*;
import java.util.Date;

// Legacy code with issues:
// - Poor naming (Item vs Product)
// - Using double for money (precision issues)
// - Using Date instead of LocalDateTime
@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public String name;
    public String desc; // Abbreviated field name
    public double price; // Using double for money - PRECISION ISSUE
    public String sku;
    public int qty; // Abbreviated field name

    @Temporal(TemporalType.TIMESTAMP)
    public Date created;

    public int status; // Using int instead of enum

    // Missing category
    // No validation
    // Poor field names
}
