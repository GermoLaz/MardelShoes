package com.project.Shoes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String number; //hasheado con endpoint especial
    private String last4Numbers;
    private String expirationDate;
    private String code; //hasheado con endpoint especial
    private String name;

    @OneToOne(fetch = FetchType.EAGER) //Eager o Lazzy
    @JoinColumn(name = "dni") //FK cliente
    private Client client;
}
