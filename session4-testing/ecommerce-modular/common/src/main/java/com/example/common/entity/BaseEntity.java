package com.example.common.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Base entity class providing common fields and functionality for all entities.
 * Entities should extend this class to inherit:
 * - id (primary key with auto-generation)
 * - createdAt (timestamp set on creation)
 * - updatedAt (timestamp updated automatically on modification)
 */
@MappedSuperclass
public abstract class BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    
    @Column(nullable = false, updatable = false)
    protected LocalDateTime createdAt = LocalDateTime.now();
    
    protected LocalDateTime updatedAt;
    
    @PrePersist
    protected void prePersist() {
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
    }
    
    @PreUpdate
    protected void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}

