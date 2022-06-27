package com.maxprogrammer.crm.person_api.dtos;

import com.maxprogrammer.crm.person_api.models.PersonModel;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class PersonDto {

    @NotBlank
    private String name;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String phone;

    public PersonModel newPerson() {
        return new PersonModel(name, email, phone);
    }
}
