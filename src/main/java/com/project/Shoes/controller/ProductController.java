package com.project.Shoes.controller;

import com.project.Shoes.model.Product;
import com.project.Shoes.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/")
    public Product add(@RequestBody final Product product){
        return productService.add(product);
    }

    @GetMapping("/{productCode}")
    public Product findByProductCode(@PathVariable String productCode){
        return productService.findByProductCode(productCode);
    }
}