package com.project.Shoes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
public class TripDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer productStock;

    @OneToOne()
    @JoinColumn(name = "product_code")
    private Product product;

    @ManyToOne()
    @JoinColumn(name = "tripHeaderId")
    private TripHeader tripHeader;

}
