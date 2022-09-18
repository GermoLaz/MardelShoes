package com.project.Shoes.controller;

import com.project.Shoes.model.SaleHeader;
import com.project.Shoes.service.SaleHeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/saleHeader")
public class SaleHeaderController {
    @Autowired
    private SaleHeaderService saleHeaderService;

    @PostMapping("/")
    public ResponseEntity add(@RequestBody final SaleHeader saleHeader){
        return saleHeaderService.add(saleHeader);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleHeader> findById(@PathVariable Integer id){
        return saleHeaderService.findById(id);
    }
}
