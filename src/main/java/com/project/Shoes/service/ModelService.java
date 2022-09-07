package com.project.Shoes.service;

import com.project.Shoes.model.Model;
import com.project.Shoes.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import static com.project.Shoes.util.EntityURLBuilder.buildURL;

@Service
public class ModelService {
    private final String PATH = "model";
    @Autowired
    private ModelRepository modelRepository;

    public ResponseEntity<Model> findByModelCode(String modelCode) {
        Model model = modelRepository.findByModelCode(modelCode);
        return model == null ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() : ResponseEntity.status(HttpStatus.OK).body(model);
    }

    public ResponseEntity add(Model model) {
        if (findByModelCode(model.getModelCode()).getBody() != null)
            throw new HttpClientErrorException(HttpStatus.CONFLICT, "Model Already Exist");

        Model mod = modelRepository.save(model);
        return ResponseEntity.status(HttpStatus.CREATED)
                .location(buildURL( PATH, mod.getId().toString())).build(); //.header()
    }
}
