package com.project.Shoes.controller;

import com.project.Shoes.model.Address;
import com.project.Shoes.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @PostMapping("/")
    public ResponseEntity add(@RequestBody final Address address){
        return addressService.add(address);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> findById(@PathVariable Integer id){
        return addressService.findById(id);
    }

    @GetMapping("/dni/{dni}")//arreglar
    public ResponseEntity<List<Address>> findAllByPerson(@PathVariable String dni){
        return addressService.findAllByClient(dni);
    }
}
