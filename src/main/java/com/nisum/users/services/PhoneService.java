package com.nisum.users.services;

import com.nisum.users.data.Phone;
import com.nisum.users.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PhoneService {

    @Autowired
    private PhoneRepository phoneRepository;

    public void save(Phone phone) {

        phone.setId(UUID.randomUUID().toString());
        phoneRepository.save(phone);

    }
}
