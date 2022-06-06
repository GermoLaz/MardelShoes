package com.project.Shoes.service;

import com.project.Shoes.model.Model;
import com.project.Shoes.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModelService {
    @Autowired
    private ModelRepository modelRepository;

    public Model findByModelCode(String modelCode) {
        return modelRepository.findByModelCode(modelCode);
    }

    public Model add(Model model) {
        return modelRepository.save(model);
    }
}
