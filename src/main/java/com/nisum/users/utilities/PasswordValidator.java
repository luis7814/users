package com.nisum.users.utilities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class PasswordValidator {

    @Value("${password.regex}")
    private String regex;

    public boolean isValid(String password) {
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(password).matches();
    }

}
