package com.project.Shoes.service;

import com.project.Shoes.model.Brand;
import com.project.Shoes.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandService {
    @Autowired
    private BrandRepository brandRepository;

    public Brand findByBrandCode(String brandCode) {
        return brandRepository.findByBrandCode(brandCode);
    }

    public Brand add(Brand brand) {
        return brandRepository.save(brand);
    }
}
