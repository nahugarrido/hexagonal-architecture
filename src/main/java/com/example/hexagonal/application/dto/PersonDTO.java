package com.example.hexagonal.application.dto;

import com.example.hexagonal.infrastructure.entity.PersonEntity;
import lombok.Data;

@Data
public class PersonDTO {
    private int id;
    private String name;
    private String email;

    public static PersonDTO fromEntity(PersonEntity personEntity) {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setId(personEntity.getId());
        personDTO.setName(personEntity.getName());
        personDTO.setEmail(personEntity.getEmail());
        return personDTO;
    }
}
