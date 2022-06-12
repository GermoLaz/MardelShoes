package com.project.Shoes.service;

import com.project.Shoes.model.Province;
import com.project.Shoes.repository.ProvinceRepository;
import com.project.Shoes.util.PostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.io.IOException;

import static com.project.Shoes.util.EntityURLBuilder.buildURL;
@Service
public class ProvinceService {
    @Autowired
    ProvinceRepository provinceRepository;

    public Province findById(Integer id) {
          return provinceRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NO_CONTENT, "This province not exist"));
    }

    public PostResponse add(Province province) {
        //validar que no este cargada
        Province prov = provinceRepository.save(province);

        return PostResponse.builder()
                .httpStatus(HttpStatus.CREATED)
                .url(buildURL("province",prov.getId().toString())).build();
    }
}
