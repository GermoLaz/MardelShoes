package com.project.Shoes.model;

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
public class Brand {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private String brandCode;
    private String description;

    @OneToMany(mappedBy = "brand"/*, cascade = CascadeType.ALL, orphanRemoval = true*/)
    @JsonManagedReference(value="model-brand")
    private List<Model> models;
}
