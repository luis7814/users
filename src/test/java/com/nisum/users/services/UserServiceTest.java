package com.nisum.users.services;

import com.nisum.users.data.User;
import com.nisum.users.repository.UserRepository;
import com.nisum.users.utilities.PasswordValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class UserServiceTest {
    @Mock
    UserRepository userRepository;
    @Mock
    PasswordValidator passwordValidator;
    @InjectMocks
    UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSave() {
        when(passwordValidator.isValid(anyString())).thenReturn(true);

        User result = userService.save(userData());
        Assertions.assertNull(result);
        Assertions.assertEquals(null, result);
    }

    private User userData() {

        User user = new User();
        user.setPassword("Haker2*");

        return user;
    }
}
