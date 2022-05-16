package com.project.Shoes.controller;

import com.project.Shoes.model.Address;
import com.project.Shoes.repository.AddressRepository;
import com.project.Shoes.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    AddressService addressService;

    @PostMapping("/")
    public Address add(@RequestBody final Address address){
        return addressService.add(address);
    }

    @GetMapping("/{id}")
    public Address findById(@PathVariable Integer id){
        return addressService.findById(id);
    }

    @GetMapping("/dni/{dni}")//arreglar
    public Address findAllByClient(@PathVariable String dni){
        return addressService.findAllByClient(dni);
    }
}
