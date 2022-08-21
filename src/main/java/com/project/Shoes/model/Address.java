package com.project.Shoes.model;

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

    @OneToOne(fetch = FetchType.EAGER) //Eager o Lazzy
    @JoinColumn(name = "location_id") //FK de location
    private Location location;

    @ManyToOne()
    @JoinColumn(name = "dni") //FK persona
    private Person person; //porque el person puede tener muchas direcciones
}