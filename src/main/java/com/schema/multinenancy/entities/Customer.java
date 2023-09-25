package com.schema.multinenancy.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
public class Customer extends BaseEntity {

    private String name;
    private String surname;
    private String login;
    private String password;
    @ManyToOne
    private Address address;

}