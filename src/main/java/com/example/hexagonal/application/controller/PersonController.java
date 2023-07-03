package com.example.hexagonal.application.controller;

import com.example.hexagonal.application.dto.PersonDTO;
import com.example.hexagonal.application.dto.PersonSaveDTO;
import com.example.hexagonal.domain.port.IPersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {
    private final IPersonService iPersonService;
    public PersonController(IPersonService iPersonService) {
        this.iPersonService = iPersonService;
    }

    @GetMapping
    public List<PersonDTO> getAllPersons() {
        return iPersonService.getAllPersons();
    }

    @GetMapping(value = "/{person_id}")
    public PersonDTO findPersonById(@PathVariable Integer person_id) {
        return iPersonService.getPersonById(person_id);
    }

    @PostMapping(value = "/create")
    public void createPerson(@RequestBody PersonSaveDTO person) {
        iPersonService.createPerson(person);
    }

    /// update

    @DeleteMapping(value = "/delete/{person_id}")
    public void deletePerson(@PathVariable Integer person_id) {
        iPersonService.deletePerson(person_id);
    }
}
