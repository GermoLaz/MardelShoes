package com.project.Shoes.controller;

import com.project.Shoes.model.Client;
import com.project.Shoes.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/")
    public Client add(@RequestBody final Client client){
        return clientService.add(client);
    }

    @GetMapping("/{dni}")
    public Client findByDni(@PathVariable String dni) {
        return clientService.findByDni(dni);
    }

}
