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
public class SalesTrip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToMany(mappedBy = "salesTrip"/*, cascade = CascadeType.ALL, orphanRemoval = true*/)
    private List<User> users;
    private String car;
}
