package com.project.Shoes.service;

import com.project.Shoes.model.SaleDetail;
import com.project.Shoes.model.SaleHeader;
import com.project.Shoes.repository.SaleDetailRepository;
import com.project.Shoes.repository.SaleHeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class SaleHeaderService {
    @Autowired
    SaleHeaderRepository saleHeaderRepository;

    public SaleHeader findById(Integer id) {
        return saleHeaderRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, ""));
    }

    public SaleHeader add(SaleHeader saleHeader) {
        return saleHeaderRepository.save(saleHeader);
    }
}
