package com.project.Shoes.repository;

import com.project.Shoes.model.Card;
import com.project.Shoes.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Client> {
    Card findByClientDni(String dni);

    Card findByNumber(String number);
}
