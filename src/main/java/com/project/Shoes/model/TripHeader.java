/*package com.project.Shoes.model;

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
    private String car;


    private List<User> users;

    @OneToMany(mappedBy = "tripHeaderId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TripDetail> tripDetails;
}
*/
