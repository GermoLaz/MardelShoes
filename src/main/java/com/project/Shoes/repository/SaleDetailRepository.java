package com.project.Shoes.repository;

import com.project.Shoes.model.Province;
import com.project.Shoes.model.SaleDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleDetailRepository extends JpaRepository<SaleDetail, Integer> {
}
