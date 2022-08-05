package com.project.Shoes.controller;

import com.project.Shoes.model.Province;
import com.project.Shoes.model.SaleDetail;
import com.project.Shoes.service.ProvinceService;
import com.project.Shoes.service.SaleDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/saleDetail")
public class SaleDetailController {

    @Autowired
    private SaleDetailService saleDetailService;

    @PostMapping("/")
    public SaleDetail add(@RequestBody final SaleDetail saleDetail){
        return saleDetailService.add(saleDetail);
    }

    @GetMapping("/{id}")
    public SaleDetail findById(@PathVariable Integer id){
        return saleDetailService.findById(id);
    }
}

