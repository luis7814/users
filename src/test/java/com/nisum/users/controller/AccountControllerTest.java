package com.nisum.users.controller;

import com.nisum.users.data.AccountDto;
import com.nisum.users.facade.AccountFacade;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;

class AccountControllerTest {
    @Mock
    AccountFacade accountFacade;
    @InjectMocks
    AccountController accountController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSave() {
        when(accountFacade.registerAccount(any())).thenReturn(new AccountDto());

        ResponseEntity<AccountDto> result = accountController.save(new AccountDto());
        Assertions.assertNotNull(result);
        Assertions.assertEquals(true, result.getStatusCode().is2xxSuccessful());
    }
}
