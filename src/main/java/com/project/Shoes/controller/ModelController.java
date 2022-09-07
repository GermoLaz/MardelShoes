package com.project.Shoes.controller;

import com.project.Shoes.model.Model;
import com.project.Shoes.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/model")
public class ModelController {
    @Autowired
    private ModelService modelService;

    @PostMapping("/")
    public ResponseEntity add(@RequestBody final Model model){
        return modelService.add(model);
    }

    @GetMapping("/{modelCode}")
    public ResponseEntity<Model> findByModelCode(@PathVariable String modelCode){
        return modelService.findByModelCode(modelCode);
    }
}