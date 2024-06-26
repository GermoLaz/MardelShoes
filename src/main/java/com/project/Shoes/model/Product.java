package com.project.Shoes.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @Id
    private Integer id;
    private String productCode;
    private String description;
    private Integer stock;
    private String size;

    @ManyToOne()
    @JoinColumn(name = "model_code")
    @JsonBackReference(value="model-products")
    private Model model;  //brand adidas = ad , model predator = pr , size = N26 (Niño talle 26)  => modelCode = ADPRN26

    @OneToOne(mappedBy = "product")
    @JsonManagedReference(value = "product-saleDetail")
    private SaleDetail saleDetail;

    @OneToOne(mappedBy = "product")
    @JsonManagedReference(value = "product-tripDetail")
    private TripDetail tripDetail;
}
