package com.legacy.repositories;

import com.legacy.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepo extends JpaRepository<Item, Long> {

    @Query(value = "SELECT * FROM items WHERE sku = ?1", nativeQuery = true)
    Item findBySku(String sku);

    @Query(value = "SELECT * FROM items WHERE status = 1", nativeQuery = true)
    List<Item> findActiveItems();

    // Inefficient query - no pagination
    @Query(value = "SELECT * FROM items", nativeQuery = true)
    List<Item> getAllItems();
}
