package com.project.Shoes.service;

import com.project.Shoes.model.Address;
import com.project.Shoes.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public Address findById(Integer id) {
        return addressRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, ""));
    }

    public Address add(Address address) {
        return addressRepository.save(address);
    }

    public List<Address> findAllByClient(String dni) {
        return addressRepository.findAllByPersonDni(dni);

    }
}
