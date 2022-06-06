package com.project.Shoes.repository;

import com.project.Shoes.model.Client;
import com.project.Shoes.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, String> { // Tipo de dato que se postea , y PK
    Person findByDni(String dni);
}
