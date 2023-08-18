package com.nisum.users.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "person")
public class Person implements Serializable {

    @Id
    private String id;
    private String name;
    private String email;

}
