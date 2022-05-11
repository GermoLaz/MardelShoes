package com.project.Shoes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
public class User extends Person {

    private int role;
    private String userName;
    private String password;
}
