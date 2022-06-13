package com.project.Shoes.controller;

import com.project.Shoes.model.Address;
import com.project.Shoes.model.Location;
import com.project.Shoes.service.LocationService;
import com.project.Shoes.util.PostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/location")
public class LocationController {
    @Autowired
    private LocationService locationService;

    @PostMapping("/")
    public ResponseEntity add(@RequestBody final Location location){
        return locationService.add(location);
    }

    @GetMapping("/{id}")
    public Location findById(@PathVariable Integer id){
        return locationService.findById(id);
    }
}
