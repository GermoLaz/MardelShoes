package com.project.Shoes.repository;

import com.project.Shoes.model.SaleDetail;
import com.project.Shoes.model.SaleHeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleDetailRepository extends JpaRepository<SaleDetail, Integer> {

}
