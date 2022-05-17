package com.project.Shoes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
public class User extends Person {

    private int role;
    private String userName;
    private String password;

    @ManyToOne()
    @JoinColumn(name = "dni")
    private SalesTrip salesTrip;

    public SalesTrip getSalesTrip() {
        return salesTrip;
    }
}
