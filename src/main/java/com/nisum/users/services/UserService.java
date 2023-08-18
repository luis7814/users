package com.nisum.users.services;

import com.nisum.users.exceptions.BadRequestException;
import com.nisum.users.data.User;
import com.nisum.users.repository.UserRepository;
import com.nisum.users.utilities.PasswordValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordValidator passwordValidator;

    @Autowired
    private JwtService jwtService;

    public User save(User user) {

        validateData(user.getPassword());

        user.setId(UUID.randomUUID().toString());
        user.setCreated(LocalDateTime.now());
        user.setLastLogin(LocalDateTime.now());
        user.setToken(UUID.randomUUID().toString());
        user.setInactive(false);

        return userRepository.save(user);

    }

    private void validateData(String password) {

        if (!passwordValidator.isValid(password)) {
            throw new BadRequestException("Debe ingresar una contraseña valida");
        }
    }


}
