package com.project.Shoes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
public class SaleHeader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double totalAmount;
    private Integer paymentInstallments;

    @ManyToOne()
    @JoinColumn(name = "client_dni")
    private String clientDni;

    @ManyToOne()
    @JoinColumn(name = "user_dni") // user = seller
    private String userDni;

    @OneToMany(mappedBy = "salesHeaderId")
    private List<SaleDetail> items;


}