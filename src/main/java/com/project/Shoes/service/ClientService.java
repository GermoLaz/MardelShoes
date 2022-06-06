package com.project.Shoes.service;

import com.project.Shoes.model.Client;
import com.project.Shoes.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    private PersonRepository clientRepository;

    public Client findByDni(String dni) {
        Client client = (Client) clientRepository.findByDni(dni);
        return client;
    }

    public Client add(Client client) {
        return clientRepository.save(client);
    }


}