package com.aspirecoders.instock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aspirecoders.instock.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, String> {
    // You can add custom query methods here if needed
}
