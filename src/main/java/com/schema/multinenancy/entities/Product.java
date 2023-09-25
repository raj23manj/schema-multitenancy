package com.schema.multinenancy.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
@Builder
public class Product extends BaseEntity{

    private String name;
    private String description;
    private BigDecimal price;

    @OneToOne
    private Warehouse warehouse;

}