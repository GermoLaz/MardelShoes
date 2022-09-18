package com.project.Shoes.repository;

import com.project.Shoes.model.TripHeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripHeaderRepository extends JpaRepository<TripHeader, Integer> {
}
