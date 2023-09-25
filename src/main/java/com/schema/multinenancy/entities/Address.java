package com.schema.multinenancy.entities;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
public class Address extends BaseEntity {

    private String street;
    private String houseNo;
    private String flatNo;
    private String zipCode;
    private String city;
    private String country;

}