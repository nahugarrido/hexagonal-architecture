package com.example.hexagonal.application.service;

import com.example.hexagonal.application.dto.PersonDTO;
import com.example.hexagonal.application.dto.PersonSaveDTO;
import com.example.hexagonal.application.mapper.PersonMapper;
import com.example.hexagonal.domain.model.Person;
import com.example.hexagonal.domain.port.IPersonRepository;
import com.example.hexagonal.domain.port.IPersonService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImpPersonService implements IPersonService {

    private final IPersonRepository iPersonRepository;

    public ImpPersonService(IPersonRepository iPersonRepository) {
        this.iPersonRepository = iPersonRepository;
    }

    @Override
    public void createPerson(PersonSaveDTO person) {
        Person savedPerson = PersonMapper.toDomain(person);
        iPersonRepository.savePerson(savedPerson);
    }

    @Override
    public void updatePerson(PersonDTO person) {
    }

    @Override
    public List<PersonDTO> getAllPersons() {
       List<Person> personList = iPersonRepository.getAll();
        List<PersonDTO> personDTOList = new ArrayList<>();

       for(Person item: personList) {
           PersonDTO aux = PersonMapper.toDTO(item);
           personDTOList.add(aux);
       }

       return personDTOList;
    }

    @Override
    public PersonDTO getPersonById(Integer id) {
       Person person = iPersonRepository.getById(id);
       PersonDTO personDTO = PersonMapper.toDTO(person);
       return personDTO;
    }

    @Override
    public void deletePerson(Integer id) {
        iPersonRepository.deletePerson(id);
    }
}
