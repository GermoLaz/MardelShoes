package com.project.Shoes.service;

import com.project.Shoes.model.SaleHeader;
import com.project.Shoes.model.TripHeader;
import com.project.Shoes.repository.TripHeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import static com.project.Shoes.util.EntityURLBuilder.buildURL;

@Service
public class TripHeaderService {
    private final String PATH = "card";
    @Autowired
    TripHeaderRepository tripHeaderRepository;

    public ResponseEntity<TripHeader> findById(Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(tripHeaderRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "")));
    }

    public ResponseEntity add(TripHeader tripHeader) {
        if (findById(tripHeader.getId()).getBody() != null){
            throw new HttpClientErrorException(HttpStatus.CONFLICT, "SaleHeader Already Exist");
        }
        TripHeader tripHeaderAux = tripHeaderRepository.save(tripHeader);

        return ResponseEntity.status(HttpStatus.CREATED)
                .location(buildURL( PATH, tripHeader.getId().toString())).build();
    }
}
