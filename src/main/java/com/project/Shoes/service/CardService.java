package com.project.Shoes.service;

import com.project.Shoes.model.Card;
import com.project.Shoes.model.Client;
import com.project.Shoes.repository.BrandRepository;
import com.project.Shoes.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;

    public Card findByClientDni(String dni){
        return cardRepository.findByClientDni(dni);
    }
    public Card add(Card card){
        return cardRepository.save(card);
    }
}
