package com.project.Shoes.repository;

import com.project.Shoes.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<Model, String> {
    Model findByModelCode(String modelCode);
}
