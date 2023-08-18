package com.nisum.users.data;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class AccountDto implements Serializable {

    private String name;
    private String email;
    private String password;
    private List<Phone> phones;
    private String id;
    private LocalDateTime created;
    private LocalDateTime modified;
    private LocalDateTime lastLogin;
    private String token;
    private Boolean inactive;
}
