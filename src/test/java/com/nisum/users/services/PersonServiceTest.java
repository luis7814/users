package com.nisum.users.services;

import com.nisum.users.data.Person;
import com.nisum.users.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class PersonServiceTest {
    @Mock
    PersonRepository personRepository;
    @InjectMocks
    PersonService personService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindByEmail() {
        when(personRepository.findByEmail(anyString())).thenReturn(personData());

        Person result = personService.findByEmail("email");
        Assertions.assertNotNull(result);
        Assertions.assertEquals("Juanito", result.getName());
    }

    private Person personData() {

        Person person = new Person();
        person.setEmail("juanito1@gmail.com");
        person.setName("Juanito");
        return person;
    }
}