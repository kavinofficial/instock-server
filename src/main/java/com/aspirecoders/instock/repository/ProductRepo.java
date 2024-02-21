package com.aspirecoders.instock.repository;

import com.aspirecoders.instock.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    // You can add custom query methods here if needed
}
