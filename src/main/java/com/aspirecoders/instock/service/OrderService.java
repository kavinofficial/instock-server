package com.aspirecoders.instock.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aspirecoders.instock.model.Order;
import com.aspirecoders.instock.repository.OrderRepo;

@Service
public class OrderService {
    @Autowired
    public OrderRepo orderRepo;

    public List<Order> getOrder() {
        return orderRepo.findAll();
    }

    @SuppressWarnings("null")
    public boolean addOrder(Order inv) {
        try {
            orderRepo.save(inv);
            return true;
        } catch (Exception e) {

            System.out.println(e);
            return false;
        }
    }

    @SuppressWarnings("static-access")
    public Order getById(long id) {
        Optional<Order> invOptional = orderRepo.findById(id);
        if (invOptional.empty() == null) {
            return null;
        }
        return invOptional.get();
    }

    public Order editOrder(long id, Order inv) {
        Order old = orderRepo.findById(id).orElse(null);
        old.setCreatedAt(inv.getCreatedAt());
        old.setCustomerId(inv.getCustomerId());
        old.setDeliveryStatus(inv.getDeliveryStatus());
        old.setOrderId(inv.getOrderId());
        old.setProductId(inv.getProductId());
        old.setQuantity(inv.getQuantity());
        old.setStatus(inv.getStatus());
        old.setTotalAmount(inv.getTotalAmount());
        orderRepo.saveAndFlush(old);
        return old;
    }

    public boolean deleteById(long id) {
        try {
            orderRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}