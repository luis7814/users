package com.nisum.users.services;

import com.nisum.users.data.Phone;
import com.nisum.users.repository.PhoneRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class PhoneServiceTest {
    @Mock
    PhoneRepository phoneRepository;
    @InjectMocks
    PhoneService phoneService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSave() {
        phoneService.save(new Phone());
    }
}