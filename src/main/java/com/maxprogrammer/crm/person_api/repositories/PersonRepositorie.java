package com.maxprogrammer.crm.person_api.repositories;

import com.maxprogrammer.crm.person_api.models.PersonModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepositorie extends JpaRepository<PersonModel, Long> {
}
