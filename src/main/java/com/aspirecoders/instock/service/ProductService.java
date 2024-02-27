package com.aspirecoders.instock.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aspirecoders.instock.model.Product;
import com.aspirecoders.instock.repository.ProductRepo;

@Service
public class ProductService {
    // You can add custom methods here if needed
    @Autowired
    public ProductRepo productRepo;

    public boolean saveProduct(Product product) {
        try {
            productRepo.save(product);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Product> getAllProduct() {
        return productRepo.findAll();
    }

    public Optional<Product> getProductById(long product_id) {
        return productRepo.findById(product_id);
    }

    public boolean putByProductId(long id, Product product) {
        Product pro = productRepo.findById(id).orElse(null);

        if (pro == null) {
            return false;
        } else {
            try {
                // pro.setProductId(product.getProductId());
                // pro.setBrandId(product.getBrandId());
                // pro.setProductName(product.getProductName());
                // pro.setCreatedAt(product.getCreatedAt());
                productRepo.saveAndFlush(pro);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
    }

    public boolean deleteById(long id) {
        Product p = productRepo.findById(id).orElse(null);

        if (p == null) {
            return false;
        } else {
            try {
                productRepo.deleteById(id);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
    }
}