package com.project.Shoes.repository;

import com.project.Shoes.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<Brand, String> {
    Brand findByBrandCode(String brandCode);
}
