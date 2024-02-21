package com.aspirecoders.instock.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.aspirecoders.instock.model.Product;
import com.aspirecoders.instock.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class ProductController {

    @Autowired
    public ProductService productService;

    @PostMapping("/user/product")
    public ResponseEntity<Product> postMethodName(@RequestBody Product entity) {
        if (productService.saveProduct(entity)) {
            return new ResponseEntity<>(entity, HttpStatus.OK);
        }
        return new ResponseEntity<>(entity, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/user/getproduct")
    public ResponseEntity<List<Product>> getMethodName() {
        List<Product> product = productService.getAllProduct();
        if (product.isEmpty()) {
            return new ResponseEntity<>(product, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/user/getproductbyid/{product_id}")
    public ResponseEntity<Product> getMethodName(@PathVariable long product_id) {
        Optional<Product> product = productService.getProductById(product_id);
        if (product.isPresent()) {
            return new ResponseEntity<>(product.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(product.get(), HttpStatus.NOT_FOUND);
    }

    @PutMapping("/user/put/{id}")
    public ResponseEntity<Product> putMethodName(@PathVariable long id, @RequestBody Product entity) {
        if (productService.putByProductId(id, entity)) {
            return new ResponseEntity<>(entity, HttpStatus.OK);
        }
        return new ResponseEntity<>(entity, HttpStatus.NOT_FOUND);
    }

    @SuppressWarnings("rawtypes")
    @DeleteMapping("/user/products/{id}")
    public ResponseEntity deleteMethod(@PathVariable int id) {
        if (productService.deleteById(id)) {
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
