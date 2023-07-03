package com.example.hexagonal.infrastructure.repository;

import com.example.hexagonal.application.dto.PersonDTO;
import com.example.hexagonal.domain.model.Person;
import com.example.hexagonal.domain.port.IPersonRepository;
import com.example.hexagonal.infrastructure.entity.PersonEntity;
import com.example.hexagonal.infrastructure.mapper.PersonEntityMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JpaPersonRepositoryAdapter implements IPersonRepository {
    private final JpaPersonRepository jpaPersonRepository;

    public JpaPersonRepositoryAdapter(JpaPersonRepository jpaPersonRepository) {
        this.jpaPersonRepository = jpaPersonRepository;
    }

    @Override
    public void savePerson(Person person) {
        PersonEntity savedPerson = PersonEntityMapper.toEntity(person);
        jpaPersonRepository.save(savedPerson);
    }

    @Override
    public void deletePerson(Integer id) {
        jpaPersonRepository.deleteById(id);
    }

    @Override
    public Person getById(Integer id) {
        PersonEntity person = jpaPersonRepository.getReferenceById(id);
        return PersonEntityMapper.toDomain(person);
    }

    @Override
    public List<Person> getAll() {
        List<PersonEntity> listPersonEntity = jpaPersonRepository.findAll();
        List<Person> listPerson = new ArrayList<>();

        for(PersonEntity item : listPersonEntity) {
            Person aux = PersonEntityMapper.toDomain(item);
            listPerson.add(aux);
        }

        return listPerson;
    }
}
