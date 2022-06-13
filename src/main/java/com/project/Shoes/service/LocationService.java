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

    public Location findById(Integer id) {
        return locationRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, ""));
    }

    public ResponseEntity add(Location location) {
        if (findByDescription(location.getDescription()).getBody() != null){
            throw new HttpClientErrorException(HttpStatus.CONFLICT, "Province Already Exist");
//            return ResponseEntity.status(HttpStatus.CONFLICT)
//                    .body(new ErrorBody("Location Already Exist", 409));
        }
        Location loc = locationRepository.save(location);
        return ResponseEntity.status(HttpStatus.CREATED)
                .location(buildURL( PATH, loc.getId().toString())).build(); //.header()
    }

    public ResponseEntity<Location> findByDescription(String description){
        Location location = locationRepository.findByDescription(description);
        return location == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).build() : ResponseEntity.status(HttpStatus.OK).body(location);
    }
}
