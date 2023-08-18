package com.nisum.users.facade;

import com.nisum.users.exceptions.BadRequestException;
import com.nisum.users.exceptions.NotFoundException;
import com.nisum.users.data.AccountDto;
import com.nisum.users.data.Person;
import com.nisum.users.data.Phone;
import com.nisum.users.data.User;
import com.nisum.users.services.PersonService;
import com.nisum.users.services.PhoneService;
import com.nisum.users.services.UserService;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class AccountFacade {

    @Autowired
    private PersonService personService;

    @Autowired
    private UserService userService;

    @Autowired
    private PhoneService phoneService;

    @Transactional
    public AccountDto registerAccount(AccountDto accountDto) {

        validateData(accountDto);

        if (personService.findByEmail(accountDto.getEmail()) == null) {

            Person person = new Person();
            person.setName(accountDto.getName());
            person.setEmail(accountDto.getEmail());
            personService.save(person);

            accountDto.getPhones().forEach((a) -> {

                Phone phone = new Phone();
                phone.setPersonId(person.getId());
                phone.setNumber(a.getNumber());
                phone.setCityCode(a.getCityCode());
                phone.setCountryCode(a.getCountryCode());
                phoneService.save(phone);
            });

            User user = new User();
            user.setPassword(accountDto.getPassword());
            user.setPersonId(person.getId());
            userService.save(user);

            accountDto.setId(user.getId());
            accountDto.setInactive(user.getInactive());
            accountDto.setCreated(user.getCreated());
            accountDto.setModified(user.getModified());
            accountDto.setLastLogin(user.getLastLogin());
            accountDto.setToken(user.getToken());

        } else {
            throw new BadRequestException("El correo electrónico ingresado, ya existe.");
        }

        return accountDto;
    }

    private void validateData(AccountDto accountDto) {

        if (StringUtils.isBlank(accountDto.getName())) {
            throw new NotFoundException("Debe ingresar un nombre");
        }
        if (StringUtils.isBlank(accountDto.getEmail())) {
            throw new NotFoundException("Debe ingresar un correo eletrónico");
        }
        if (StringUtils.isBlank(accountDto.getPassword())) {
            throw new NotFoundException("Debe ingresar una constraseña");
        }
    }


}
