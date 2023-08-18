package com.nisum.users.services;

import com.nisum.users.exceptions.BadRequestException;
import com.nisum.users.data.Person;
import com.nisum.users.repository.PersonRepository;
import com.nisum.users.utilities.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person save(Person person) {

        validateData(person);
        person.setId(UUID.randomUUID().toString());
        return personRepository.save(person);
    }

    public Person findByEmail(String email) {
        return personRepository.findByEmail(email);
    }

    private void validateData(Person person) {

        if (!EmailValidator.isValid(person.getEmail())) {
            throw new BadRequestException("Debe ingresar un correo electrónico valido");
        }
    }

}
