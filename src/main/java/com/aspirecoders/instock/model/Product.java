package com.aspirecoders.instock.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long productId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    private Brand brand;
    private long categoryId;
    private String productName;
    private byte[] image;
    private String description;
    private double price;
    private Date createdAt;
}
