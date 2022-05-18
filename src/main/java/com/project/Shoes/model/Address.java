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

    @OneToOne(fetch = FetchType.EAGER) //Eager o Lazzy
    @JoinColumn(name = "location_id") //FK de location
    private Integer locationId;

    @ManyToOne()
    //@JsonIgnore
    @JoinColumn(name = "dni") //FK persona
    private String personDni; //porque el person puede tener muchas direcciones
}