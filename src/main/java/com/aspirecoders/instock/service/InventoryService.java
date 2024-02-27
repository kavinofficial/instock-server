package com.aspirecoders.instock.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aspirecoders.instock.model.Inventory;
import com.aspirecoders.instock.repository.InventoryRepo;

@Service
public class InventoryService {
    @Autowired
    public InventoryRepo inventoryRepo;

    public List<Inventory> getInventory() {
        return inventoryRepo.findAll();
    }

    @SuppressWarnings("null")
    public boolean addInventory(Inventory inv) {
        try {
            inventoryRepo.save(inv);
            return true;
        } catch (Exception e) {

            System.out.println(e);
            return false;
        }
    }

    @SuppressWarnings("static-access")
    public Inventory getById(int id) {
        Optional<Inventory> invOptional = inventoryRepo.findById(id);
        if (invOptional.empty() == null) {
            return null;
        }
        return invOptional.get();
    }

    public Inventory editInventory(int id, Inventory inv) {
        Inventory old = inventoryRepo.findById(id).orElse(null);
        if(old!=null)
            return inventoryRepo.saveAndFlush(old);
        return old;
    }

    public boolean deleteById(int id) {
        try {
            inventoryRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}