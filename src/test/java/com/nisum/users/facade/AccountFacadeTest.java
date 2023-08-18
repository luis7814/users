package com.nisum.users.facade;

import com.nisum.users.data.AccountDto;
import com.nisum.users.data.Person;
import com.nisum.users.data.Phone;
import com.nisum.users.data.User;
import com.nisum.users.services.PersonService;
import com.nisum.users.services.PhoneService;
import com.nisum.users.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class AccountFacadeTest {
    @Mock
    PersonService personService;
    @Mock
    UserService userService;
    @Mock
    PhoneService phoneService;
    @InjectMocks
    AccountFacade accountFacade;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegisterAccount() {
        when(personService.save(any())).thenReturn(personData());
        when(personService.findByEmail(anyString())).thenReturn(null);
        when(userService.save(any())).thenReturn(userData());

        AccountDto result = accountFacade.registerAccount(accountDtoData());
        Assertions.assertNotNull(result);
        Assertions.assertEquals("juanito1@gmail.com", result.getEmail());
    }

    private AccountDto accountDtoData() {

        List<Phone> phones = new ArrayList<>();
        Phone phone = new Phone();
        phone.setId("");
        phone.setNumber("123");
        phone.setCountryCode("1");
        phone.setCityCode("156");
        phones.add(phone);

        AccountDto accountDto = new AccountDto();
        accountDto.setName("Juanito");
        accountDto.setPassword("Haker2*");
        accountDto.setEmail("juanito1@gmail.com");
        accountDto.setPhones(phones);

        return accountDto;
    }

    private Person personData() {

        Person person = new Person();
        person.setEmail(accountDtoData().getEmail());
        person.setName(accountDtoData().getName());
        return person;
    }

    private User userData() {

        User user = new User();
        user.setPassword(accountDtoData().getPassword());

        return user;
    }
}