package com.example.hexagonal.infrastructure.mapper;

import com.example.hexagonal.domain.model.Person;
import com.example.hexagonal.infrastructure.entity.PersonEntity;

public class PersonEntityMapper {
    public static Person toDomain(PersonEntity entity) {
        Person person = new Person();
        person.setId(entity.getId());
        person.setName(entity.getName());
        person.setEmail(entity.getEmail());
        return person;
    }

    public static PersonEntity toEntity(Person person) {
        PersonEntity entity = new PersonEntity();
        entity.setId(person.getId());
        entity.setName(person.getName());
        entity.setEmail(person.getEmail());
        return entity;
    }
}
