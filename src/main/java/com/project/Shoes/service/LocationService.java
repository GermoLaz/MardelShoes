package com.project.Shoes.service;

import com.project.Shoes.model.Location;
import com.project.Shoes.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import static com.project.Shoes.util.EntityURLBuilder.buildURL;

@Service
public class LocationService {
    private final String PATH = "location";
    @Autowired
    LocationRepository locationRepository;

    public ResponseEntity<Location> findById(Integer id) {
        Location location = locationRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, ""));
        return ResponseEntity.status(HttpStatus.OK)
                .body(location);
    }

    public ResponseEntity add(Location location) {
        if (findByDescription(location.getDescription()).getBody() != null){
            throw new HttpClientErrorException(HttpStatus.CONFLICT, "Location Already Exist");
        }
        Location loc = locationRepository.save(location);
        return ResponseEntity.status(HttpStatus.CREATED)
                .location(buildURL( PATH, loc.getId().toString()))
                .build(); //.header()
    }

    public ResponseEntity<Location> findByDescription(String description){
        Location location = locationRepository.findByDescription(description);
        return location == null ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() : ResponseEntity.status(HttpStatus.OK).body(location);
    }
}
