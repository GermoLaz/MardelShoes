package com.project.Shoes.service;

import com.project.Shoes.model.Card;
import com.project.Shoes.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import static com.project.Shoes.util.EntityURLBuilder.buildURL;

@Service
public class CardService {
    private final String PATH = "card";
    @Autowired
    private CardRepository cardRepository;

    public ResponseEntity<Card> findByClientDni(String dni){
        Card card = cardRepository.findByClientDni(dni);
        return card == null ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() : ResponseEntity.status(HttpStatus.OK).body(card);
    }

    public ResponseEntity add(Card card){
        if (findByNumber(card.getNumber()).getBody() != null){
            throw new HttpClientErrorException(HttpStatus.CONFLICT, "Card Already Exist");
        }
        Card cardAux = cardRepository.save(card);

        return ResponseEntity.status(HttpStatus.CREATED)
                .location(buildURL( PATH, cardAux.getId().toString())).build();
    }

    public ResponseEntity<Card> findByNumber(String number){
        Card card = cardRepository.findByNumber(number);
        return card == null ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() : ResponseEntity.status(HttpStatus.OK).body(card);
    }
}
