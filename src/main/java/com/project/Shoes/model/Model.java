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
public class Model {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private String modelCode;
    private String description;

    @ManyToOne
    @JsonBackReference(value="model-brand")
    @JoinColumn(name = "brand_code")
    private Brand brand;

    @OneToMany(mappedBy = "model")
    @JsonManagedReference(value="model-products")
    private List<Product> products;
}
