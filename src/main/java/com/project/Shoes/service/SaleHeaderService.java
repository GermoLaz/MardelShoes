package com.project.Shoes.service;

import com.project.Shoes.model.SaleHeader;
import com.project.Shoes.repository.SaleHeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import static com.project.Shoes.util.EntityURLBuilder.buildURL;

@Service
public class SaleHeaderService {
    private final String PATH = "saleHeader";
    @Autowired
    SaleHeaderRepository saleHeaderRepository;

    public ResponseEntity<SaleHeader> findById(Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(saleHeaderRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "")));
    }

    public ResponseEntity add(SaleHeader saleHeader) {
        SaleHeader saleHeaderAux = saleHeaderRepository.save(saleHeader);

        return ResponseEntity.status(HttpStatus.CREATED)
                .location(buildURL( PATH, saleHeaderAux.getId().toString())).build();
    }
}
