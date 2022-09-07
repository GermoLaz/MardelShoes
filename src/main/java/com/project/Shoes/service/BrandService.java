package com.project.Shoes.service;

import com.project.Shoes.model.Brand;
import com.project.Shoes.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import static com.project.Shoes.util.EntityURLBuilder.buildURL;

@Service
public class BrandService {

    private final String PATH = "brand";
    @Autowired
    private BrandRepository brandRepository;
    public ResponseEntity add(Brand brand) {
        if (findByBrandCode(brand.getBrandCode()).getBody() != null)
            throw new HttpClientErrorException(HttpStatus.CONFLICT, "Brand Already Exist");
        Brand br = brandRepository.save(brand);

        return ResponseEntity.status(HttpStatus.CREATED)
                .location(buildURL( PATH, br.getId().toString())).build(); //.header()
    }

    public ResponseEntity<Brand> findByBrandCode(String brandCode) {
        Brand brand = brandRepository.findByBrandCode(brandCode);
        return brand == null ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() : ResponseEntity.status(HttpStatus.OK).body(brand);
    }
}
