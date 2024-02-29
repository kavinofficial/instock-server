package com.aspirecoders.instock.controller;

import org.springframework.web.bind.annotation.RestController;

import com.aspirecoders.instock.model.Inventory;
import com.aspirecoders.instock.service.InventoryService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    @Autowired
    InventoryService inventoryService;

    @GetMapping("")
    public List<Inventory> getDetails() {
        return inventoryService.getInventory();
    }

    @GetMapping("/{id}")
    public Inventory get(@PathVariable long id) {
        return inventoryService.getById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<Inventory> postMethod(@RequestBody Inventory inv) {
        if (inventoryService.addInventory(inv)) {
            return new ResponseEntity<>(inv, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(inv, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Inventory> putMethodName(@PathVariable int id, @RequestBody Inventory entity) {
        return new ResponseEntity<>(inventoryService.editInventory(id, entity), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMethod(@PathVariable int id) {
        if (inventoryService.deleteById(id)) {
            return ResponseEntity.ok().body("Successfully deleted");
        }
        return ResponseEntity.internalServerError().body("Deletion aborted");
    }

    @GetMapping("/page/{offset}/{size}")
    public List<Inventory> getPage(@PathVariable("offset") int offset, @PathVariable("size") int size) {
        return inventoryService.getPageList(offset, size);
    }

    @GetMapping("/sort/{field}/{sortBy}")
    public List<Inventory> sortPage(@PathVariable("field") String field, @PathVariable("sortBy") String sortBy) {
        return inventoryService.sortPageList(field, sortBy);
    }

    @GetMapping("/page/{offset}/{size}/{field}/{sortBy}")
    public List<Inventory> sortPaginate(@PathVariable("offset") int offset, @PathVariable("size") int size,
            @PathVariable("field") String field, @PathVariable("sortBy") String sortBy) {
        return inventoryService.sortAndPaginate(offset, size, sortBy, field);
    }
}
