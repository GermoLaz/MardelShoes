package com.project.Shoes.service;

import com.project.Shoes.model.Province;
import com.project.Shoes.model.SaleDetail;
import com.project.Shoes.repository.ProvinceRepository;
import com.project.Shoes.repository.SaleDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class SaleDetailService {
    @Autowired
    SaleDetailRepository saleDetailRepository;

    public SaleDetail findById(Integer id) {
        return saleDetailRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, ""));
    }

    public SaleDetail add(SaleDetail saleDetail) {
        return saleDetailRepository.save(saleDetail);
    }
}
