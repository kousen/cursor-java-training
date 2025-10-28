package com.example.hellospring.dto;

import com.example.hellospring.entity.Person;

public record PersonResponse(
    Long id,
    String firstName,
    String lastName,
    String email
) {
    public static PersonResponse from(Person person) {
        return new PersonResponse(
            person.getId(),
            person.getFirstName(),
            person.getLastName(),
            person.getEmail()
        );
    }
}

