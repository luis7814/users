package com.nisum.users.repository;

import com.nisum.users.data.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, String> {
}
