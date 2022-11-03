package com.project.Shoes.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    //private String last4Numbers;
    private String expirationDate;
    //private String code; //hasheado con endpoint especial
    private String name;
    private String bank;
    private String type; //debit, credit

    @OneToOne(fetch = FetchType.EAGER) //Eager o Lazzy?
    @JoinColumn(name = "dni") //FK cliente_dni
    @JsonBackReference(value = "client-card")
    private Client client;
}
