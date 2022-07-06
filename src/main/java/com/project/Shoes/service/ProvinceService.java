package com.project.Shoes.service;

import com.project.Shoes.model.Province;
import com.project.Shoes.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import static com.project.Shoes.util.EntityURLBuilder.buildURL;
@Service
public class ProvinceService {
    private final String PATH = "province";
    private ProvinceRepository provinceRepository;

    @Autowired
    public ProvinceService(ProvinceRepository provinceRepository) {
        this.provinceRepository = provinceRepository;
    }

    public ResponseEntity<Province> findById(Integer id) {
        Province province = provinceRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NO_CONTENT, "This province not exist"));
          return ResponseEntity.status(HttpStatus.OK)
                  .body(province);// header("","")
    }

    public ResponseEntity add(Province province) throws HttpClientErrorException{
        if(findByDescription(province.getDescription()).getBody() != null){
            //throw new ResponseStatusException(HttpStatus.CONFLICT, "Province Already Exist");
            //return ResponseEntity.status(HttpStatus.CONFLICT)
                    //.body(new ErrorBody("Province Already Exist", 409));
            throw new HttpClientErrorException(HttpStatus.CONFLICT, "Province Already Exist");
        }
        return ResponseEntity.status(HttpStatus.CREATED)
                .location(buildURL("PATH",provinceRepository.save(province).getId().toString())).build(); //.header()
    }

    public ResponseEntity<Province> findByDescription(String description){
        Province province = provinceRepository.findByDescription(description);
        return province == null ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() : ResponseEntity.status(HttpStatus.OK).body(province);
    }
}
