package com.example.hexagonal.domain.port;

import com.example.hexagonal.application.dto.PersonDTO;
import com.example.hexagonal.application.dto.PersonSaveDTO;

import java.util.List;

public interface IPersonService {

    void createPerson(PersonSaveDTO person);
    void updatePerson(PersonDTO person);
    List<PersonDTO> getAllPersons();
    PersonDTO getPersonById(Integer id);
    void deletePerson(Integer id);


}
