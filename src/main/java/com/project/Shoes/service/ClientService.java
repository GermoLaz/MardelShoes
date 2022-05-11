package com.project.Shoes.service;

import com.project.Shoes.model.Client;
import com.project.Shoes.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public Client findByDni(String dni) {
        return clientRepository.findById(dni).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, ""));
    }

    public Client add(Client client) {
        return clientRepository.save(client);
    }


}