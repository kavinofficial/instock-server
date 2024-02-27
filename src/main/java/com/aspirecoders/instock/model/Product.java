package com.aspirecoders.instock.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long productIdd;
    private long brandId;
    private long categoryId;
    private String productName;
    private byte[] image;
    private String description;
    private double price;
    private Date createdAt;
}
