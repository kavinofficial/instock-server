package com.aspirecoders.instock.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aspirecoders.instock.enums.OrderStatus;
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
        if (old != null)
            orderRepo.saveAndFlush(old);
        return null;
    }

    public boolean deleteById(long id) {
        try {
            orderRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public int getCount(OrderStatus orderStatus) {
        return orderRepo.getCountOfStatus(orderStatus);
    }
}