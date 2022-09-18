package com.project.Shoes.service;

import com.project.Shoes.model.Model;
import com.project.Shoes.model.Product;
import com.project.Shoes.repository.ModelRepository;
import com.project.Shoes.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import static com.project.Shoes.util.EntityURLBuilder.buildURL;

@Service
public class ProductService {
    private final String PATH = "product";

    @Autowired
    private ProductRepository productRepository;

    public ResponseEntity<Product> findByProductCode(String productCode) {
        Product product = productRepository.findByProductCode(productCode);
        return product == null ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() : ResponseEntity.status(HttpStatus.OK).body(product);
    }

    public ResponseEntity add(Product product) {
        if (findByProductCode(product.getProductCode()).getBody() != null){
            throw new HttpClientErrorException(HttpStatus.CONFLICT, "Product Already Exist");
        }
        Product productAux = productRepository.save(product);

        return ResponseEntity.status(HttpStatus.CREATED)
                .location(buildURL( PATH, productAux.getId().toString())).build();
    }
}
