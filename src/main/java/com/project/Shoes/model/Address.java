package com.project.Shoes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String street;
    private String number;

    //DB relations

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "location_id") //FK de location
    private Location location;
    @ManyToOne()
    //@JsonIgnore
    @JoinColumn(name = "dni") //FK cliente
    private Client client; //porque el cliente puede tener muchas direcciones
}