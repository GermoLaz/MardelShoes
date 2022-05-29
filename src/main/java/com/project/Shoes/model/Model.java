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
public class Model {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Id
    private String modelCode;
    private String description;

    @ManyToOne
    @JoinColumn(name = "brand_code")
    private Brand brand;

    @OneToMany(mappedBy = "model")
    @JsonIgnore
    private List<Product> products;
}
