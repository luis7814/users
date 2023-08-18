package com.nisum.users.controller;

import com.nisum.users.data.AccountDto;
import com.nisum.users.facade.AccountFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    private AccountFacade accountFacade;

    @PostMapping("/user")
    public ResponseEntity<AccountDto> save(@RequestBody AccountDto accountDto) {
        return new ResponseEntity<>(accountFacade.registerAccount(accountDto), HttpStatus.OK);
    }
}
