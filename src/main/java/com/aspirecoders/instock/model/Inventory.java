package com.aspirecoders.instock.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int prod_id;
    private int category_id;
    private byte[] image;
    private String description;
    private float price;
    private int stocks;
    private Date created;
}
