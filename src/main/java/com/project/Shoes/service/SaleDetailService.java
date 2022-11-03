package com.project.Shoes.service;

import com.project.Shoes.model.SaleDetail;
import com.project.Shoes.repository.SaleDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

import static com.project.Shoes.util.EntityURLBuilder.buildURL;

@Service
public class SaleDetailService {
    private final String PATH = "saleDetail";
    @Autowired
    SaleDetailRepository saleDetailRepository;

    public ResponseEntity<SaleDetail> findById(Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(saleDetailRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "")));
    }

    public ResponseEntity add(SaleDetail saleDetail) {
        SaleDetail saleDetailAux = saleDetailRepository.save(saleDetail);
        return ResponseEntity.status(HttpStatus.CREATED)
                .location(buildURL( PATH, saleDetailAux.getId().toString())).build();
    }
}
