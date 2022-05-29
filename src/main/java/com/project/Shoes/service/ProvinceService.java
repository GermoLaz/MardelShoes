package com.project.Shoes.service;

import com.project.Shoes.model.Province;
import com.project.Shoes.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
@Service
public class ProvinceService {
    @Autowired
    ProvinceRepository provinceRepository;

    public Province findById(Integer id) {
        return provinceRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, ""));
    }

    public Province add(Province province) {
        return provinceRepository.save(province);
    }
}
