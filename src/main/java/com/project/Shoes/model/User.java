package com.project.Shoes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
public class User extends Person {

    private int role;
    private String userName;
    private String password;

   /* @ManyToOne()
    @JoinColumn(name = "dni")
    private TripHeader tripHeader;
    */
   @OneToMany(mappedBy = "userDni")
   @JsonIgnore
   private List<SaleHeader> salesList;


}
