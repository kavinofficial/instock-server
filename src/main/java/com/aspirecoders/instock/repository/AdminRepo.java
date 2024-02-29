package com.aspirecoders.instock.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aspirecoders.instock.model.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, String> {

    Optional<Admin> findByEmail(String email);

}