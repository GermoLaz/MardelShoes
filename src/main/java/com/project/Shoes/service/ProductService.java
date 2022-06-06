package com.project.Shoes.service;

import com.project.Shoes.model.Model;
import com.project.Shoes.model.Product;
import com.project.Shoes.repository.ModelRepository;
import com.project.Shoes.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product findByProductCode(String productCode) {
        return productRepository.findByProductCode(productCode);
    }

    public Product add(Product product) {
        return productRepository.save(product);
    }
}
