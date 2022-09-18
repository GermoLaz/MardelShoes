package com.project.Shoes.controller;

import com.project.Shoes.model.Province;
import com.project.Shoes.model.SaleDetail;
import com.project.Shoes.service.ProvinceService;
import com.project.Shoes.service.SaleDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/saleDetail")
public class SaleDetailController {

    @Autowired
    private SaleDetailService saleDetailService;

    @PostMapping("/")
    public ResponseEntity add(@RequestBody final SaleDetail saleDetail){
        return saleDetailService.add(saleDetail);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<SaleDetail>> findBySaleHeaderId(@PathVariable Integer id){
        return saleDetailService.findBySaleHeaderId(id);
    }
}

