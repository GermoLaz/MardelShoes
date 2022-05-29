package com.project.Shoes.service;

import com.project.Shoes.model.Brand;
import com.project.Shoes.model.Client;
import com.project.Shoes.repository.BrandRepository;
import com.project.Shoes.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

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
