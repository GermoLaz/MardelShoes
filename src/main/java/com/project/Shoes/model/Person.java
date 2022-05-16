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
public class Person {

    @Id
    private String dni;
    private String name;
    private String lastname;

    @OneToMany(mappedBy = "client"/*, cascade = CascadeType.ALL, orphanRemoval = true*/)
    @JsonIgnore
    private List<Address> addresses;
}
