package com.project.Shoes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Id
    private String productCode;
    private String description;
    private Integer stock;
    private String size;
    private Double price;

    @ManyToOne()
    @JoinColumn(name = "model_code")
    private String modelCode;  //brand adidas = ad , model predator = pr , size = N26 (Niño talle 26)  => modelCode = ADPRN26

    @ManyToOne(optional = false)
    @JoinColumn(name = "tripStock_id")
    private Integer tripDetail;

    @OneToOne(mappedBy = "productCode")
    @JsonIgnore
    private SaleDetail saleDetail;
}