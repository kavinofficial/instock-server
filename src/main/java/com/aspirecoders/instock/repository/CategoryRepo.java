package com.aspirecoders.instock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aspirecoders.instock.model.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
  // You can add custom query methods here if needed
}