package com.example.hexagonal.application.mapper;

import com.example.hexagonal.application.dto.PersonDTO;
import com.example.hexagonal.application.dto.PersonSaveDTO;
import com.example.hexagonal.domain.model.Person;

public class PersonMapper {
    public static Person toDomain(PersonDTO dto) {
        Person person = new Person();
        person.setId(dto.getId());
        person.setName(dto.getName());
        person.setEmail(dto.getEmail());
        return person;
    }
    public static Person toDomain(PersonSaveDTO dto) {
        Person person = new Person();
        person.setName(dto.getName());
        person.setEmail(dto.getEmail());
        return person;
    }

    public static PersonDTO toDTO(Person person) {
        PersonDTO dto = new PersonDTO();
        dto.setId(person.getId());
        dto.setName(person.getName());
        dto.setEmail(person.getEmail());
        return dto;
    }

    public static PersonSaveDTO toSaveDTO(Person person) {
        PersonSaveDTO dto = new PersonSaveDTO();
        dto.setName(person.getName());
        dto.setEmail(person.getEmail());
        return dto;
    }
}
