package com.aspirecoders.instock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api")
public class BrandController {

  @Autowired
  private BrandService brandService;

  @GetMapping("/brand")
  public List<Brand> getAllBrands() {
    return brandService.getAllBrands();
  }

  @GetMapping("/brand/{id}")
  public Brand getBrandById(@PathVariable long id) {
    return brandService.getBrandById(id);
  }

  @PostMapping("/brand")
  public Brand createBrand(@RequestBody Brand brand) {
    return brandService.createBrand(brand);
  }

  @PutMapping("/brand/{id}")
  public Brand updateBrand(@PathVariable long id, @RequestBody Brand brand) {
    return brandService.updateBrand(id, brand);
  }

  @DeleteMapping("/brand/{id}")
  public void deleteBrand(@PathVariable long id) {
    brandService.deleteBrand(id);
  }

}
