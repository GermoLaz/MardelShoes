package com.project.Shoes.service;

import com.project.Shoes.model.Person;
import com.project.Shoes.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import static com.project.Shoes.util.EntityURLBuilder.buildURL;

@Service
public class PersonService {

    private final String PATH = "person";
    @Autowired
    private PersonRepository personRepository;

    public ResponseEntity<Person> findByDni(String dni) {
        Person person = personRepository.findByDni(dni);
        return person == null ? ResponseEntity.status(HttpStatus.NO_CONTENT
        ).build() : ResponseEntity.status(HttpStatus.OK).body(person);
    }

    public ResponseEntity add(Person person) {
        if (findByDni(person.getDni()).getBody() != null){
            throw new HttpClientErrorException(HttpStatus.CONFLICT, "Person Already Exist");
//            return ResponseEntity.status(HttpStatus.CONFLICT)
//                    .body(new ErrorBody("Person Already Exist", 409));
        }
        Person per = personRepository.save(person);
        return ResponseEntity.status(HttpStatus.CREATED)
                .location(buildURL(PATH, per.getDni())).build(); //.header()
    }


}