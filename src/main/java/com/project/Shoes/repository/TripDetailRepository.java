package com.project.Shoes.repository;

import com.project.Shoes.model.TripDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripDetailRepository extends JpaRepository<TripDetail, Integer> {
    List<TripDetail> findByTripHeaderId(Integer id);
}
