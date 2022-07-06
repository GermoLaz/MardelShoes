package com.project.Shoes.service;

import com.project.Shoes.model.Address;
import com.project.Shoes.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

import static com.project.Shoes.util.EntityURLBuilder.buildURL;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public ResponseEntity<Address> findById(Integer id) {
        Address address = addressRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NO_CONTENT, "This address not exist"));
        return ResponseEntity.status(HttpStatus.OK)
                .body(address);
    }

    public ResponseEntity add(Address address) {
        if(findByStreetAndNumber(address.getStreet(), address.getNumber()).getBody() != null)
            throw new HttpClientErrorException(HttpStatus.CONFLICT, "Address Already Exist");

        return ResponseEntity.status(HttpStatus.CREATED)
                .location(buildURL("PATH",addressRepository.save(address).getId().toString())).build(); //.header()
    }

    public ResponseEntity<Address> findByStreetAndNumber(String street, String number){
        Address address = addressRepository.findByStreetAndNumber(street, number);
        return address == null ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() : ResponseEntity.status(HttpStatus.OK).body(address);
    }

    public ResponseEntity<List<Address>> findAllByClient(String dni) {
        List<Address> addressList= addressRepository.findAllByPersonDni(dni);
        return addressList.isEmpty() ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() : ResponseEntity.status(HttpStatus.OK).body(addressList);

    }
}
