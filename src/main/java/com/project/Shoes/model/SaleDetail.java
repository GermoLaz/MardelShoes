package com.project.Shoes.model;

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
    private String productCode;

    @ManyToOne()
    @JoinColumn(name = "salesHeader_id")
    private Integer salesHeaderId;



}