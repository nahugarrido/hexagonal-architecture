package com.example.hexagonal.domain.port;

import com.example.hexagonal.domain.model.Person;

import java.util.List;

public interface IPersonRepository {
    void savePerson(Person person);

    void deletePerson(Integer id);

    Person getById(Integer id);

    List<Person> getAll();
}
