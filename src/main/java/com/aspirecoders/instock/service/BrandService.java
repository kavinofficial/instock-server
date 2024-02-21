package com.aspirecoders.instock.service;

import com.aspirecoders.instock.model.Brand;
import com.aspirecoders.instock.repository.BrandRepo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandService {

    @Autowired
    private BrandRepo brandRepo;

    public Brand createBrand(Brand brand) {
        return brandRepo.save(brand);
    }

    public Brand getBrandById(long brandId) {
        return brandRepo.findById(brandId).orElse(null);
    }

    public List<Brand> getAllBrands() {
        return brandRepo.findAll();
    }

    public Brand updateBrand(long brandId, Brand brand) {
        Brand existingBrand = brandRepo.findById(brandId).orElse(null);

        if (existingBrand != null) {
            existingBrand.setBrandName(brand.getBrandName());
            existingBrand.setBrandDescription(brand.getBrandDescription());
            existingBrand.setBrandCountry(brand.getBrandCountry());
            existingBrand.setBrandLogo(brand.getBrandLogo());
            return brandRepo.save(existingBrand);
        }

        return null;
    }

    public void deleteBrand(long brandId) {
        brandRepo.deleteById(brandId);
    }

}
