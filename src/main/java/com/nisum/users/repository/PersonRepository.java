package com.nisum.users.repository;

import com.nisum.users.data.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, String> {

    Person findByEmail(String email);
}
