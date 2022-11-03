package com.project.Shoes.controller;

import com.project.Shoes.model.TripDetail;
import com.project.Shoes.service.SaleDetailService;
import com.project.Shoes.service.TripDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tripDetail")
public class TripDetailController {

    @Autowired
    private TripDetailService tripDetailService;

    @PostMapping("/")
    public ResponseEntity add(@RequestBody final TripDetail tripDetail){
        return tripDetailService.add(tripDetail);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TripDetail> findById(@PathVariable Integer id){
        return tripDetailService.findById(id);
    }
}

