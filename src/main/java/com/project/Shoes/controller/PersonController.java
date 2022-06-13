package com.project.Shoes.controller;

import com.project.Shoes.model.Person;
import com.project.Shoes.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/")
    public ResponseEntity add(@RequestBody final Person person){
        return personService.add(person);
    }

    @GetMapping("/{dni}")
    public ResponseEntity<Person> findByDni(@PathVariable String dni) {
        return personService.findByDni(dni);
    }

}
