package com.project.Shoes.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonTypeName("client")
@EqualsAndHashCode(callSuper = true)
@Entity
public class Client extends Person {

    private String phone;
    private String occupation;
    private String workingHours;
    private String paymentDate;
    private boolean debtor;

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "client-card")
    private Card card;

    @OneToMany(mappedBy = "client")
    @JsonManagedReference(value="client-saleHeader")
    private List<SaleHeader> shoppingList;

}
