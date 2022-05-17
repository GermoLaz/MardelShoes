package com.project.Shoes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Required;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;
    private String description;
    private String brand;
    private Double price;
    private Integer stock;

    @ManyToOne(optional = false)
    @JoinColumn(name = "tripStock_id")
    private TripStock tripStock;


}
