package com.schema.multinenancy.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
public class Warehouse extends BaseEntity{

    private BigDecimal amount;

    @OneToOne(mappedBy="warehouse")
    private Product product;

}