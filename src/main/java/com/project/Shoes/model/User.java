package com.project.Shoes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonTypeName("user")
@EqualsAndHashCode(callSuper = true)
@Entity
public class User extends Person {

    private int role;
    private String userName;
    private String password;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<SaleHeader> salesList;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<TripHeader> tripHeaderList;
}
