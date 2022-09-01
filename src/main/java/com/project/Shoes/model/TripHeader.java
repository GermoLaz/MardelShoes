package com.project.Shoes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
public class TripHeader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne()
    @JoinColumn(name = "user_dni") //FK de user
    private User user;


    @OneToMany(mappedBy = "tripHeader")
    private List<TripDetail> tripDetailList;
}

