package com.maxprogrammer.crm.person_api.controllers;

import com.maxprogrammer.crm.person_api.dtos.PersonDto;
import com.maxprogrammer.crm.person_api.models.PersonModel;
import com.maxprogrammer.crm.person_api.services.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@RestController
public class PersonController {

    @Autowired
    PersonService personService;

    @PostMapping(value = "/api/person")
    @Operation(summary = "Add a new Person")
    @Transactional
    public void addNewPerson(@RequestBody @Valid PersonDto personDto) {
        personService.savePerson(personDto);
    }

    @GetMapping(value = "/api/person/{id}")
    @Operation(summary = "Consult a person by id")
    public Optional<PersonModel> getPersonById(@PathVariable("id") Long id) {
        return personService.getPersonById(id);
    }

    @GetMapping(value = "/api/person")
    @Operation(summary = "Return all people")
    public Page<PersonModel> getAllPeople(@PageableDefault(size = 10, page = 0,
            direction = Sort.Direction.ASC) Pageable pageable) {
        return personService.listPeople(pageable);
    }

    @PutMapping(value = "/api/person/{id}")
    @Operation(summary = "update a person by Id")
    public PersonModel updatePersonById(@PathVariable("id") Long id, @RequestBody @Valid PersonDto personDto) {
        return personService.updatePerson(id, personDto);
    }

    @Transactional
    @DeleteMapping(value = "/api/person/{id}")
    @Operation(summary = "Delete a person by id")
    public void deletePersonById(@PathVariable("id") Long id) {
        personService.deletePerson(id);
    }
}
