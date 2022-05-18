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
public class TripDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer stock;
    @OneToMany(mappedBy = "tripDetail", cascade = CascadeType.ALL, orphanRemoval = true)
    //@JsonIgnore
    private List<Product> products;
    @ManyToOne()
    @JoinColumn(name = "salesTrip_id")
    private Integer tripHeaderId;

}
*/
