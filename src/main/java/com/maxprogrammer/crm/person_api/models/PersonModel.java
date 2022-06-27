package com.maxprogrammer.crm.person_api.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class PersonModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private String phone;

    public PersonModel() {
    }

    public PersonModel(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
}
