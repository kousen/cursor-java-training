package com.legacy.controllers;

import com.legacy.models.Item;
import com.legacy.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Legacy code with issues:
// - Poor REST practices
// - No error handling
// - No validation
// - Exposing implementation details
@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping
    public Item add(@RequestBody Item item) {
        return itemService.addItem(item);
    }

    @GetMapping("/{id}")
    public Item get(@PathVariable Long id) {
        return itemService.getItem(id);
    }

    // No pagination - could return thousands of items
    @GetMapping
    public List<Item> getAll() {
        return itemService.getAllItems();
    }

    @PutMapping
    public Item update(@RequestBody Item item) {
        return itemService.addItem(item); // Reusing add method - poor design
    }

    // Using GET for state-changing operation - bad practice
    @GetMapping("/{id}/stock/add")
    public void addStock(@PathVariable Long id, @RequestParam int qty) {
        itemService.updateStock(id, qty);
    }

    // Using GET for state-changing operation
    @GetMapping("/{id}/stock/remove")
    public void removeStock(@PathVariable Long id, @RequestParam int qty) {
        itemService.updateStock(id, -qty);
    }

    // No validation on price
    @PostMapping("/{id}/price")
    public void updatePrice(@PathVariable Long id, @RequestParam double price) {
        itemService.updatePrice(id, price);
    }

    // Exposing business logic calculation in controller
    @GetMapping("/inventory/value")
    public String getTotalValue() {
        double total = itemService.calculateTotalInventoryValue();
        return "Total: $" + total;
    }

    // No proper boolean response
    @GetMapping("/stock/check")
    public String checkStock(@RequestParam String sku, @RequestParam int qty) {
        boolean available = itemService.checkStock(sku, qty);
        return available ? "Available" : "Not Available";
    }

    // Using GET for deactivation - should be DELETE or PATCH
    @GetMapping("/{id}/deactivate")
    public void deactivate(@PathVariable Long id) {
        itemService.deactivateItem(id);
    }
}
