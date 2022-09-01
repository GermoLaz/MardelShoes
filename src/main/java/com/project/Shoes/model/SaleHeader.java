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
public class SaleHeader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double installmentAmount;
    private Integer paymentInstallments; // cantidad cuotas
    private Integer paidInstallments; // cuotas pagas
    private boolean isActive;


    @ManyToOne()
    @JoinColumn(name = "client_dni")
    private Client client;

    @ManyToOne()
    @JoinColumn(name = "user_dni") // user = seller
    private User user;

    @OneToMany(mappedBy = "salesHeader")
    @JsonIgnore
    private List<SaleDetail> items;


}