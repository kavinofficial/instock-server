package com.aspirecoders.instock.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import jakarta.persistence.PrePersist;

@Entity
@Data
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String adminId;

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @Column(columnDefinition = "TIMESTAMP")
    private Date createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }

}
