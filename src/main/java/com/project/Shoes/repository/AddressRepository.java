package com.project.Shoes.repository;

import com.project.Shoes.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository  extends JpaRepository<Address, Integer> { // Tipo de dato que se postea , y PK
    //@Query("SELECT * FROM ADDRESS WHERE DNI = ?1")
    List<Address> findAllByPersonDni(String dni);//corregir
}