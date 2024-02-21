package com.aspirecoders.instock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aspirecoders.instock.model.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {
    // You can add custom query methods here if needed
}
