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
public class TripStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToMany(mappedBy = "tripStock"/*, cascade = CascadeType.ALL, orphanRemoval = true*/)
    //@JsonIgnore
    private List<Product> products;
    @ManyToOne()
    @JoinColumn(name = "salesTrip_id")
    private SalesTrip salesTrip;
    private Integer stock;

}
