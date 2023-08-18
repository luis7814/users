package com.nisum.users.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "phone")
public class Phone implements Serializable {

    @JsonIgnore
    @Id
    private String id;
    @JsonIgnore
    private String personId;
    private String number;
    private String cityCode;
    private String countryCode;
}
