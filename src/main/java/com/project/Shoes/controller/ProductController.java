package com.project.Shoes.controller;

import com.project.Shoes.model.Product;
import com.project.Shoes.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/")
    public ResponseEntity add(@RequestBody final Product product){
        return productService.add(product);
    }

    @GetMapping("/{productCode}")
    public ResponseEntity<Product> findByProductCode(@PathVariable String productCode){
        return productService.findByProductCode(productCode);
    }
}