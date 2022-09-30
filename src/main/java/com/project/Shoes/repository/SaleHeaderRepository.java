package com.project.Shoes.repository;

import com.project.Shoes.model.SaleDetail;
import com.project.Shoes.model.SaleHeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleHeaderRepository extends JpaRepository<SaleHeader, Integer> {
    /*@Query("SELECT * FROM SaleHeader sh JOIN SaleDetail sd ON sh.id = sd.saleHeader_id")
    List<SaleHeader> findAllActiveUsers();*/
}

