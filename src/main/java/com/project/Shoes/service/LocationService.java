package com.project.Shoes.service;

import com.project.Shoes.model.Address;
import com.project.Shoes.model.Location;
import com.project.Shoes.repository.LocationRepository;
import com.project.Shoes.util.PostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.HttpClientErrorException;

import static com.project.Shoes.util.EntityURLBuilder.buildURL;

@Service
public class LocationService {
    @Autowired
    LocationRepository locationRepository;

    public Location findById(Integer id) {
        return locationRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, ""));
    }

    public PostResponse add(Location location) {
        Location loc = locationRepository.save(location);
        return PostResponse.builder()
                .httpStatus(HttpStatus.CREATED)
                .url(buildURL("location", loc.getId().toString())).build();
    }
}
