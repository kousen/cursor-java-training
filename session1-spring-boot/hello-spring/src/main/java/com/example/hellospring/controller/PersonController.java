package com.example.hellospring.controller;

import com.example.hellospring.dto.PersonRequest;
import com.example.hellospring.dto.PersonResponse;
import com.example.hellospring.entity.Person;
import com.example.hellospring.repository.PersonRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
    
    private final PersonRepository personRepository;
    
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    
    @GetMapping
    public List<PersonResponse> getAllPersons() {
        return personRepository.findAll().stream()
                .map(PersonResponse::from)
                .toList();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<PersonResponse> getPersonById(@PathVariable Long id) {
        return personRepository.findById(id)
                .map(person -> ResponseEntity.ok(PersonResponse.from(person)))
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<PersonResponse> createPerson(@Valid @RequestBody PersonRequest request) {
        Person person = new Person(request.firstName(), request.lastName(), request.email());
        Person savedPerson = personRepository.save(person);
        return ResponseEntity.status(HttpStatus.CREATED).body(PersonResponse.from(savedPerson));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<PersonResponse> updatePerson(@PathVariable Long id, @Valid @RequestBody PersonRequest request) {
        return personRepository.findById(id)
                .map(existingPerson -> {
                    existingPerson.setFirstName(request.firstName());
                    existingPerson.setLastName(request.lastName());
                    existingPerson.setEmail(request.email());
                    Person updatedPerson = personRepository.save(existingPerson);
                    return ResponseEntity.ok(PersonResponse.from(updatedPerson));
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        if (personRepository.existsById(id)) {
            personRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

