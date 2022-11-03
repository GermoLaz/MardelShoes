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
public class SaleDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer units;

    @OneToOne()
    @JoinColumn(name = "product_code")
    @JsonBackReference(value = "product-saleDetail")
    private Product product;

    @ManyToOne()
    @JoinColumn(name = "saleHeader_id")
    @JsonBackReference(value = "saleHeader-saleDetail")
    private SaleHeader saleHeader;



}
