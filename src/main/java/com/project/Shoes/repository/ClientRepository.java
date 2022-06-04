package com.project.Shoes.repository;

import com.project.Shoes.model.Client;
import com.project.Shoes.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> { // Tipo de dato que se postea , y PK
    Client findByDni(String dni);
}
