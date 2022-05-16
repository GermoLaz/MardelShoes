package com.project.Shoes.repository;

import com.project.Shoes.model.Address;
import com.project.Shoes.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository  extends JpaRepository<Address, Integer> { // Tipo de dato que se postea , y PK
    //@Query("SELECT * FROM ADDRESS WHERE DNI = ?1")
    Address findAllByClient(String dni);//corregir
}