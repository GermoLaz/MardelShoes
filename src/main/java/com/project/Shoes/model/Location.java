package com.project.Shoes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
public class Location {

    //attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //primary key de location
    private String description;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "province_id") //FK de location
    private Integer provinceId;

    //DATABASE RELATIONS
    //no tiene la @joinColumn porque la location no tiene address. (ES ADDRESS la que contiene una location)
    @OneToOne(mappedBy = "locationId"/*, cascade = CascadeType.ALL, orphanRemoval = true*/) // mapeado por el atributo "LOCATION" que es la foreign key de la location en Address
    private Address address;

}
