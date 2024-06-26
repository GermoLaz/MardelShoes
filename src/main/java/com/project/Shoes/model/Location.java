package com.project.Shoes.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @ManyToOne()
    @JsonBackReference(value="location-province")
    @JoinColumn(name = "province_id") //FK de location
    private Province province;

    //DATABASE RELATIONS
    //no tiene la @joinColumn porque la location no tiene address. (ES ADDRESS la que contiene una location)
    @OneToMany(mappedBy = "location"/*, cascade = CascadeType.ALL, orphanRemoval = true*/) // mapeado por el atributo "LOCATION" que es la foreign key de la location en Address
    @JsonManagedReference(value="location-address")
    //@JsonIgnore
    private List<Address> addressList;

}
