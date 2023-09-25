package com.schema.multinenancy.dto.product;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class ProductDto {

    private String name;
    private String description;
    private BigDecimal price;
    private Long id;

}