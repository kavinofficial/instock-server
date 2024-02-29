package com.aspirecoders.instock.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aspirecoders.instock.model.Admin;
import com.aspirecoders.instock.repository.AdminRepo;

@Service
public class AdminService {

    @Autowired
    private AdminRepo adminRepo;

    public List<Admin> getAllAdmins() {
        return adminRepo.findAll();
    }

    public Optional<Admin> getAdminById(String id) {
        return adminRepo.findById(id);
    }

    public Admin createAdmin(Admin admin) {
        return adminRepo.save(admin);
    }

    public Admin updateAdmin(String id, Admin admin) {
        Optional<Admin> existingAdmin = adminRepo.findById(id);
        if (existingAdmin.isPresent()) {
            Admin updatedAdmin = existingAdmin.get();
            updatedAdmin.setFirstName(admin.getFirstName());
            updatedAdmin.setLastName(admin.getLastName());
            updatedAdmin.setEmail(admin.getEmail());
            updatedAdmin.setPassword(admin.getPassword());
            return adminRepo.save(updatedAdmin);
        } else {
            throw new IllegalArgumentException("Admin not found with id: " + id);
        }
    }

    public void deleteAdmin(String id) {
        adminRepo.deleteById(id);
    }

    public ResponseEntity<Admin> login(String email, String password) {
        Optional<Admin> admin = adminRepo.findByEmail(email);

        if (admin.isPresent()) {
            Admin foundAdmin = admin.get();
            boolean isEqual = foundAdmin.getPassword().equals(password);

            if (isEqual) {
                return ResponseEntity.ok(foundAdmin);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    public ResponseEntity<Admin> register(Admin admin) {
        Optional<Admin> existingAdmin = adminRepo.findByEmail(admin.getEmail());

        if (existingAdmin.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        Admin newAdmin = adminRepo.save(admin);
        return ResponseEntity.status(HttpStatus.CREATED).body(newAdmin);
    }

}
