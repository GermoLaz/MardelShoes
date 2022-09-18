package com.project.Shoes.controller;

import com.project.Shoes.model.SaleHeader;
import com.project.Shoes.model.TripHeader;
import com.project.Shoes.service.SaleHeaderService;
import com.project.Shoes.service.TripHeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tripHeader")
public class TripHeaderController {
    @Autowired
    private TripHeaderService tripHeaderService;

    @PostMapping("/")
    public ResponseEntity add(@RequestBody final TripHeader tripHeader){
        return tripHeaderService.add(tripHeader);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TripHeader> findById(@PathVariable Integer id){
        return tripHeaderService.findById(id);
    }
}
