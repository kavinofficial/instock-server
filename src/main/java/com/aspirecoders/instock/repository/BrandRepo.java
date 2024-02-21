package com.aspirecoders.instock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aspirecoders.instock.model.Brand;

public interface BrandRepo extends JpaRepository<Brand, Long> {
  // You can add custom query methods here if needed
}