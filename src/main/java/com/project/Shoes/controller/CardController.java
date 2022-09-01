package com.project.Shoes.controller;

import com.project.Shoes.model.Card;
import com.project.Shoes.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/card")
public class CardController {
    @Autowired
    private CardService cardService;

    @PostMapping("/")
    public ResponseEntity<Card> add(@RequestBody final Card card){
        return cardService.add(card);
    }

    @GetMapping("/{dni}")
    public ResponseEntity<Card> findByClient(@PathVariable String dni){
        return cardService.findByClientDni(dni) ;
    }
}
