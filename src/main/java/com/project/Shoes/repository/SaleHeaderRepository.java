package com.project.Shoes.repository;

import com.project.Shoes.model.SaleDetail;
import com.project.Shoes.model.SaleHeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleHeaderRepository extends JpaRepository<SaleHeader, Integer> {
}
