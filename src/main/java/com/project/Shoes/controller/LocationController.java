package com.project.Shoes.controller;

import com.project.Shoes.model.Location;
import com.project.Shoes.service.LocationService;
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
    public ResponseEntity<Location> findById(@PathVariable Integer id){
        return locationService.findById(id);
    }

    @GetMapping("/")
    public ResponseEntity<Location> findByDescription(@RequestParam String description){
        return locationService.findByDescription(description);
    }
}
