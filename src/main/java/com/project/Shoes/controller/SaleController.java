package com.project.Shoes.controller;

import com.project.Shoes.model.SaleHeader;
import com.project.Shoes.model.dto.Sale;
import com.project.Shoes.service.SaleDetailService;
import com.project.Shoes.service.SaleHeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sale")
public class SaleController {
    @Autowired
    private SaleHeaderService saleHeaderService;
    @Autowired
    private SaleDetailService saleDetailService;

    @PostMapping("/")
    public ResponseEntity add(@RequestBody Sale sale){
        SaleHeader saleHeader = (SaleHeader) saleHeaderService.add(sale.saleHeader).getBody();
        int saleHeader_id = saleHeader.getId();
        sale.saleDetail.setId(saleHeader_id);
        ResponseEntity responseEntity= saleDetailService.add(sale.saleDetail);
        return responseEntity;
    }
}
