package com.aspirecoders.instock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aspirecoders.instock.service.BrandService;
import com.aspirecoders.instock.model.Brand;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BrandController {

  @Autowired
  private BrandService brandService;

  @GetMapping("/brands")
  public List<Brand> getAllBrands() {
    return brandService.getAllBrands();
  }

  @GetMapping("/brands/{id}")
  public Brand getBrandById(@PathVariable long id) {
    return brandService.getBrandById(id);
  }

  @PostMapping("/brands")
  public Brand createBrand(@RequestBody Brand brand) {
    return brandService.createBrand(brand);
  }

  @PutMapping("/brands/{id}")
  public Brand updateBrand(@PathVariable long id, @RequestBody Brand brand) {
    return brandService.updateBrand(id, brand);
  }

  @DeleteMapping("/brands/{id}")
  public void deleteBrand(@PathVariable long id) {
    brandService.deleteBrand(id);
  }

}
