package com.project.Shoes.controller;

import com.project.Shoes.model.Province;
import com.project.Shoes.service.ProvinceService;
import com.project.Shoes.util.PostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/province")
public class ProvinceController {
    @Autowired
    private ProvinceService provinceService;

    @PostMapping("/")
    public PostResponse add(@RequestBody final Province province){
        return provinceService.add(province);
    }

    @GetMapping("/{id}")
    public Province findById(@PathVariable Integer id){
        return provinceService.findById(id);
    }
}
