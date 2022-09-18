package com.project.Shoes.service;

import com.project.Shoes.model.TripDetail;
import com.project.Shoes.repository.TripDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.project.Shoes.util.EntityURLBuilder.buildURL;

@Service
public class TripDetailService {
    private final String PATH = "tripDetail";
    @Autowired
    TripDetailRepository tripDetailRepository;

    public ResponseEntity<List<TripDetail>> findByTripHeaderId(Integer id) {
        List<TripDetail> saleDetailList= tripDetailRepository.findByTripHeaderId(id);
        return saleDetailList.isEmpty() ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() : ResponseEntity.status(HttpStatus.OK).body(saleDetailList);
    }

    public ResponseEntity add(TripDetail tripDetail) {
        TripDetail tripDetailAux = tripDetailRepository.save(tripDetail);
        return ResponseEntity.status(HttpStatus.CREATED)
                .location(buildURL( PATH, tripDetailAux.getId().toString())).build();
    }
}
