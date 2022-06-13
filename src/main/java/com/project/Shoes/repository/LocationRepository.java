package com.project.Shoes.repository;

import com.project.Shoes.model.Client;
import com.project.Shoes.model.Location;
import com.project.Shoes.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> { // Tipo de dato que se postea , y PK
    Location findByDescription(String description);
}