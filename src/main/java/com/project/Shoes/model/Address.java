package com.project.Shoes.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @ManyToOne(/*fetch = FetchType.EAGER*/) //Eager o Lazzy
    @JsonBackReference(value="location-address")
    @JoinColumn(name = "location_id") //FK de location
    private Location location;

    @ManyToOne()
    @JsonBackReference(value="person-address")
    @JoinColumn(name = "dni") //FK persona
    private Person person; //porque el person puede tener muchas direcciones
}