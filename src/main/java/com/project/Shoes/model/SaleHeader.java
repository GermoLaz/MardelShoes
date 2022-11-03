package com.project.Shoes.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonBackReference(value="client-saleHeader")
    private Person client;

    @ManyToOne()
    @JoinColumn(name = "user_dni") // user = seller
    @JsonBackReference(value = "user-salesList")
    private Person user;

    @OneToMany(mappedBy = "saleHeader")
    @JsonManagedReference(value = "saleHeader-saleDetail")
    private List<SaleDetail> items;


}