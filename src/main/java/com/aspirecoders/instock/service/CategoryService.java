package com.aspirecoders.instock.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aspirecoders.instock.model.Category;
import com.aspirecoders.instock.repository.CategoryRepo;

@Service
public class CategoryService {
    // You can add custom methods here if needed
    @Autowired
    public CategoryRepo categoryRepo;

    public boolean saveProduct(Category product) {
        try {
            categoryRepo.save(product);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Category> getAllProduct() {
        return categoryRepo.findAll();
    }

    public Optional<Category> getProductById(long category_id) {
        return categoryRepo.findById((int) category_id);
    }

    public boolean putByProductId(long id, Category category) {
        Category pro = categoryRepo.findById((int) id).orElse(null);

        if (pro == null) {
            return false;
        } else {
            try {
                // pro.setProductId(product.getProductId());
                pro.setCategoryName(category.getCategoryName());
                categoryRepo.saveAndFlush(pro);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
    }

    public boolean deleteById(long id) {
        Category p = categoryRepo.findById((int) id).orElse(null);

        if (p == null) {
            return false;
        } else {
            try {
                categoryRepo.deleteById((int) id);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
    }
}