package com.aspirecoders.instock.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.aspirecoders.instock.model.Category;
import com.aspirecoders.instock.service.CategoryService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class CategoryController {
    @Autowired
    public CategoryService categoryService;

    @PostMapping("/user/category")
    public ResponseEntity<Category> postCategory(@RequestBody Category entity) {
        if (categoryService.saveProduct(entity)) {
            return new ResponseEntity<>(entity, HttpStatus.OK);
        }
        return new ResponseEntity<>(entity, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/user/getcategory")
    public ResponseEntity<List<Category>> getCategory() {
        List<Category> product = categoryService.getAllProduct();
        if (product.isEmpty()) {
            return new ResponseEntity<>(product, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/user/getcategorybyid/{category_id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable long category_id) {
        Optional<Category> product = categoryService.getProductById(category_id);
        if (product.isPresent()) {
            return new ResponseEntity<>(product.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(product.get(), HttpStatus.NOT_FOUND);
    }

    @PutMapping("/user/putCategory/{id}")
    public ResponseEntity<Category> putCatogry(@PathVariable long id, @RequestBody Category entity) {
        if (categoryService.putByProductId(id, entity)) {
            return new ResponseEntity<>(entity, HttpStatus.OK);
        }
        return new ResponseEntity<>(entity, HttpStatus.NOT_FOUND);
    }

    @SuppressWarnings("rawtypes")
    @DeleteMapping("/user/category/{id}")
    public ResponseEntity deleteCategory(@PathVariable int id) {
        if (categoryService.deleteById(id)) {
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
