package com.project.Shoes.service;

import com.project.Shoes.model.Province;
import com.project.Shoes.repository.ProvinceRepository;
import com.project.Shoes.util.PostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.io.IOException;

import static com.project.Shoes.util.EntityURLBuilder.buildURL;
@Service
public class ProvinceService {
    @Autowired
    ProvinceRepository provinceRepository;

    public ResponseEntity<Province> findById(Integer id) {
        Province province = provinceRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NO_CONTENT, "This province not exist"));
          return ResponseEntity.status(HttpStatus.OK)
                  .body(province);// header("","")
    }

    public ResponseEntity add(Province province) {
        if(findByDescription(province.getDescription()) != null)
            throw new HttpClientErrorException(HttpStatus.CONFLICT, "Province Already Exist");
        Province prov = provinceRepository.save(province);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(prov); //.header()
                //.url(buildURL("province",prov.getId().toString())).build();
    }

    public ResponseEntity<Province> findByDescription(String description){
        Province province = provinceRepository.findByDescription(description); // .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NO_CONTENT, "This province not exist"));
        return ResponseEntity.status(HttpStatus.OK)
                .body(province); //.header()
    }
}
