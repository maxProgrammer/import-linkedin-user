package com.maxprogrammer.crm.person_api.services;

import com.maxprogrammer.crm.person_api.dtos.PersonDto;
import com.maxprogrammer.crm.person_api.models.PersonModel;
import com.maxprogrammer.crm.person_api.repositories.PersonRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    PersonRepositorie personRepositorie;


    public PersonModel savePerson(@RequestBody @Valid PersonDto personDto) {
        return personRepositorie.save(personDto.newPerson());
    }

    public Page<PersonModel> listPeople(Pageable pageable) {
        return personRepositorie.findAll(pageable);
    }

    public Optional<PersonModel> getPersonById(Long id) {
        return personRepositorie.findById(id);
    }

    @Transactional
    public PersonModel updatePerson(Long id, PersonDto personDto) {
        Optional<PersonModel> possibleIdPerson = personRepositorie.findById(id);
        PersonModel possibleDto = personDto.newPerson();
        possibleDto.setId(possibleIdPerson.get().getId());
        return personRepositorie.save(possibleDto);

    }

    @Transactional
    public void deletePerson(Long id) {
        personRepositorie.deleteById(id);
    }

}
