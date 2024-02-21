package com.aspirecoders.instock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aspirecoders.instock.model.Inventory;

public interface InventoryRepo extends JpaRepository<Inventory, Integer> {
    // You can add custom query methods here if needed
}
