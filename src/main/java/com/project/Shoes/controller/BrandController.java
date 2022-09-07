package com.project.Shoes.controller;

import com.project.Shoes.model.Brand;
import com.project.Shoes.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @PostMapping("/")
    public ResponseEntity add(@RequestBody final Brand brand){
        return brandService.add(brand);
    }

    @GetMapping("/{brandCode}")
    public ResponseEntity<Brand> findByBrandCode(@PathVariable String brandCode){
        return brandService.findByBrandCode(brandCode);
    }
}