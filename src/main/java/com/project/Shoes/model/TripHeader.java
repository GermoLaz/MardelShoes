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
public class TripHeader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne()
    @JoinColumn(name = "user_dni") //FK de user
    @JsonBackReference(value = "user-tripHeaderList")
    private User user;

    @OneToMany(mappedBy = "tripHeader")
    @JsonManagedReference(value = "tripHeader-tripDetail")
    private List<TripDetail> tripDetailList;
}

