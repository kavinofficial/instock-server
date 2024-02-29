package com.aspirecoders.instock.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort.Direction;

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
    public Inventory getById(long id) {
        Optional<Inventory> invOptional = inventoryRepo.findById(id);
        if (invOptional.empty() == null) {
            return null;
        }
        return invOptional.get();
    }

    public Inventory editInventory(long id, Inventory inv) {
        Inventory old = inventoryRepo.findById(id).orElse(null);
        if (old != null)
            return inventoryRepo.saveAndFlush(old);
        return old;
    }

    public boolean deleteById(long id) {
        try {
            inventoryRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Inventory> getPageList(int offset, int size) {
        return inventoryRepo.findAll(PageRequest.of(offset, size)).toList();
    }

    public List<Inventory> sortPageList(String field, String sortBy) {
        if (sortBy.equalsIgnoreCase("asc")) {
            return inventoryRepo.findAll(Sort.by(Direction.ASC, field));
        }
        return inventoryRepo.findAll(Sort.by(Direction.DESC, field));
    }

    public List<Inventory> sortAndPaginate(int offset, int size, String sortBy, String field) {
        if (sortBy.equalsIgnoreCase("asc")) {
            return inventoryRepo.findAll(PageRequest.of(offset, size, Direction.ASC, field)).toList();
        }
        return inventoryRepo.findAll(PageRequest.of(offset, size, Direction.DESC, field)).toList();
    }
}