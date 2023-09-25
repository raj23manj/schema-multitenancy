package com.schema.multinenancy.domain.product;

import com.schema.multinenancy.dto.product.ProductDto;

import java.util.List;

public interface ProductDomain {

    List<ProductDto> getAllProducts();

    ProductDto createProduct(ProductDto productDto);
}