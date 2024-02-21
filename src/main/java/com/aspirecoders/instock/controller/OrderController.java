package com.aspirecoders.instock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aspirecoders.instock.model.Order;
import com.aspirecoders.instock.service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("")
    public List<Order> getDetails() {
        return orderService.getOrder();
    }

    @GetMapping("/{id}")
    public Order get(@PathVariable long id) {
        return orderService.getById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<Order> postMethod(@RequestBody Order inv) {
        if (orderService.addOrder(inv)) {
            return new ResponseEntity<>(inv, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(inv, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Order> putMethodName(@PathVariable int id, @RequestBody Order entity) {
        return new ResponseEntity<>(orderService.editOrder(id, entity), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMethod(@PathVariable long id) {
        if (orderService.deleteById(id)) {
            return ResponseEntity.ok().body("Successfully deleted");
        }
        return ResponseEntity.internalServerError().body("Deletion aborted");
    }
}