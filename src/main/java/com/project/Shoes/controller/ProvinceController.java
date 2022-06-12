package com.project.Shoes.controller;

import com.project.Shoes.model.Province;
import com.project.Shoes.service.ProvinceService;
import com.project.Shoes.util.PostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/province")
public class ProvinceController {
    @Autowired
    private ProvinceService provinceService;

    @PostMapping("/")
    public ResponseEntity add(@RequestBody final Province province){
        return provinceService.add(province);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Province> findById(@PathVariable Integer id){
        return provinceService.findById(id);
    }

    @GetMapping("/")
    public ResponseEntity<Province> findByDescription(@RequestParam String description){
        return provinceService.findByDescription(description);
    }
}
