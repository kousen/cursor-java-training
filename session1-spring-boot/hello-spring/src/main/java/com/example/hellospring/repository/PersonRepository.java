package com.example.hellospring.repository;

import com.example.hellospring.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByLastName(String lastName);
    Optional<Person> findByEmail(String email);
    List<Person> findByFirstNameContainingIgnoreCase(String firstName);
}

