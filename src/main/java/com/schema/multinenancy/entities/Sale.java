package com.schema.multinenancy.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
public class Sale extends BaseEntity{

    @ManyToOne
    private Customer customer;
    @ManyToMany
    @JoinTable(
            name = "Sale_Product",
            joinColumns = @JoinColumn(name="sale_id"),
            inverseJoinColumns = @JoinColumn(name="product_id")
    )
    private List<Product> products;

}