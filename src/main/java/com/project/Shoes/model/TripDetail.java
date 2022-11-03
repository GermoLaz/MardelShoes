package com.project.Shoes.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonBackReference(value = "product-tripDetail")
    private Product product;

    @ManyToOne()
    @JoinColumn(name = "tripHeaderId")
    @JsonBackReference(value = "tripHeader-tripDetail")
    private TripHeader tripHeader;

}
