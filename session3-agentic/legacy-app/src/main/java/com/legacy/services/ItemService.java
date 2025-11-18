package com.legacy.services;

import com.legacy.models.Item;
import com.legacy.repositories.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

// Legacy code with issues:
// - No thread safety
// - No caching strategy
// - Poor error handling
@Service
public class ItemService {

    @Autowired
    private ItemRepo itemRepo;

    // No validation
    public Item addItem(Item item) {
        item.created = new Date();
        item.status = 1; // Magic number
        return itemRepo.save(item);
    }

    // Returns null instead of Optional
    public Item getItem(Long id) {
        return itemRepo.findById(id).orElse(null);
    }

    // No pagination
    public List<Item> getAllItems() {
        return itemRepo.getAllItems();
    }

    // No stock validation
    public void updateStock(Long itemId, int quantity) {
        Item item = getItem(itemId);
        item.qty = item.qty + quantity; // Could go negative
        itemRepo.save(item);
    }

    // No price validation
    public void updatePrice(Long itemId, double newPrice) {
        Item item = getItem(itemId);
        item.price = newPrice; // Could be negative or zero
        itemRepo.save(item);
    }

    // Inefficient - loads all items
    public boolean checkStock(String sku, int requiredQty) {
        Item item = itemRepo.findBySku(sku);
        if (item == null) {
            return false;
        }
        return item.qty >= requiredQty;
    }

    // No proper status enum
    public void deactivateItem(Long id) {
        Item item = getItem(id);
        item.status = 0; // Magic number
        itemRepo.save(item);
    }

    // Inefficient calculation
    public double calculateTotalInventoryValue() {
        List<Item> items = getAllItems();
        double total = 0;
        for (Item item : items) {
            total += item.price * item.qty;
        }
        return total;
    }
}
