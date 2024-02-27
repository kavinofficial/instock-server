package com.aspirecoders.instock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aspirecoders.instock.enums.OrderStatus;
import com.aspirecoders.instock.model.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {
    // You can add custom query methods here if needed
    @Query("SELECT COUNT(o) FROM Order o WHERE o.status=:status")
    public int getCountOfStatus(@Param("status") OrderStatus status);

}
