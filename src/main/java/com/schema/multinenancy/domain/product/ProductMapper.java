package com.schema.multinenancy.domain.product;

import com.schema.multinenancy.dto.product.ProductDto;
import com.schema.multinenancy.entities.Product;
import com.schema.multinenancy.entities.Warehouse;

import java.math.BigDecimal;
import java.util.Optional;

public class ProductMapper {

    public static ProductDto mapToDto(Product product) {
        return ProductDto.builder()
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }

    private static BigDecimal getAvailableAmount(Product product) {
        return Optional.ofNullable(product)
                .map(Product::getWarehouse)
                .map(Warehouse::getAmount)
                .orElse(BigDecimal.ZERO);
    }
}